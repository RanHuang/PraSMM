package com.hr.learn.service;

import com.hr.learn.jms.MoodProducer;
import com.hr.learn.mapper.PraiseMapper;
import com.hr.learn.model.praise.Mood;
import com.hr.learn.model.praise.MoodVO;
import com.hr.learn.model.praise.User;
import com.hr.learn.model.praise.UserMoodPraiseRel;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * date 2019-06-07 星期五 10:20
 **/
@Service("praiseServiceRedis")
public class PraiseServiceRedisImpl implements PraiseServiceI {
    private static final Logger logger = LoggerFactory.getLogger(PraiseServiceRedisImpl.class);

    private PraiseMapper praiseMapper;
    private RedisTemplate<String, String> redisTemplate;
    private SetOperations<String, String> setOperations;

    @Autowired
    private MoodProducer moodProducer;
    private static Destination destination = new ActiveMQQueue("com.hr.learn.jms.praise");

    @Autowired
    public PraiseServiceRedisImpl(PraiseMapper praiseMapper, RedisTemplate<String, String> redisTemplate) {
        this.praiseMapper = praiseMapper;
        this.redisTemplate = redisTemplate;
        this.setOperations = redisTemplate.opsForSet();
    }

    @Override
    public List<MoodVO> queryMood() {
        this.redisTemplate.opsForSet();
        List<Mood> lstMood = praiseMapper.queryMood();

        List<MoodVO> lstMoodVO = new ArrayList<>(lstMood.size());
        for (Mood mood : lstMood) {
            MoodVO moodVO = new MoodVO();
            moodVO.setId(mood.getId());
            moodVO.setContent(mood.getContent());
            int praiseNumDb = mood.getPraiseNum();
            Long praiseNumRedis = this.setOperations.size(mood.getId());
            int praiseNum = praiseNumDb + (praiseNumRedis == null ? 0 : praiseNumRedis.intValue());
            moodVO.setPraiseNum(praiseNum);
            String userId = mood.getUserId();
            moodVO.setUserId(userId);
            moodVO.setPublishTime(mood.getPublishTime());

            User user = praiseMapper.getUser(userId);
            if (user != null) {
                moodVO.setUserName(user.getName());
                moodVO.setUserAccount(user.getAccount());
            } else {
                logger.warn("Miss the information of User, userId:{}", userId);
            }

            lstMoodVO.add(moodVO);
        }

        return lstMoodVO;
    }

    @Override
    public boolean praiseMood(String userId, String moodId) {
        // 发送异步消息
        UserMoodPraiseRel rel = new UserMoodPraiseRel(userId, moodId);
        moodProducer.sendMessage(destination, rel);
        // 向Redis写入数据
        /*this.setOperations.add(RedisConstant.REDIS_SET_KEY_PRAISE, moodId);
        this.setOperations.add(moodId, userId);*/
        return true;
    }
}
