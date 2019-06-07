package com.hr.learn.job;

import com.hr.learn.constant.RedisConstant;
import com.hr.learn.mapper.PraiseMapper;
import com.hr.learn.model.praise.Mood;
import com.hr.learn.model.praise.UserMoodPraiseRel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;

/**
 * @author nick
 * date 2019-06-07 星期五 11:10
 **/
@Component
@Configurable
@EnableScheduling
public class PraiseDataWriteDbJob implements RedisConstant {
    private static final Logger logger = LoggerFactory.getLogger(PraiseDataWriteDbJob.class);

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private PraiseMapper praiseMapper;

    @Scheduled(cron = "*/15 * * * * *")
    public void persistPraiseDataFromRedisToDb() {
        logger.info("开始定时任务-将Redis缓存数据写入DataBase");
        Set<String> moodIds = redisTemplate.opsForSet().members(REDIS_SET_KEY_PRAISE);
        if (CollectionUtils.isEmpty(moodIds)) {
            logger.info("定时任务，无点赞记录");
            return;
        }

        int count = 0;
        for (String moodId : moodIds) {
            Set<String> userIds = redisTemplate.opsForSet().members(moodId);
            if (CollectionUtils.isEmpty(userIds)) {
                logger.info("定时任务，存在moodId:{}, 但是不存在点赞用户", moodId);
                continue;
            }

            for (String userId : userIds) {
                UserMoodPraiseRel rel = new UserMoodPraiseRel(userId, moodId);
                // 保存点赞用户与说说的关系
                int ret = praiseMapper.addUserMoodPraiseRel(rel);
                count += ret;
            }

            // 更新说说的点赞数量 = Redis缓存的点赞数量 + DB中的点赞数量
            Mood mood = praiseMapper.getMood(moodId);
            Long praiseNumRedis = this.redisTemplate.opsForSet().size(moodId);
            int praiseNum = mood.getPraiseNum() + (Objects.isNull(praiseNumRedis) ? 0 : praiseNumRedis.intValue());
            mood.setPraiseNum(praiseNum);
            praiseMapper.updateMood(mood);

            // 清除缓存数据
            redisTemplate.delete(moodId);
        }
        logger.info("定时任务，一共处理 {} 条点赞记录", count);
        // 清除缓存数据
        // 此种模式存在问题，在执行定时任务过程中，已经将点赞记录写入库的说说，可能又有用户对其点赞，
        // 在Job执行完后这部分数据随着清空缓存可能出现数据丢失，可以在执行定时任务前将集合数据先进行拷贝，
        // 只对拷贝数据进行操作
        this.redisTemplate.delete(REDIS_SET_KEY_PRAISE);
    }
}
