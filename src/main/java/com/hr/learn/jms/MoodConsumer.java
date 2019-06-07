package com.hr.learn.jms;

import com.hr.learn.constant.RedisConstant;
import com.hr.learn.model.praise.UserMoodPraiseRel;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author nick
 * date 2019-06-07 星期五 22:34
 **/
@Component("moodConsumer")
public class MoodConsumer implements MessageListener, RedisConstant {
    private static final Logger logger = LoggerFactory.getLogger(MoodConsumer.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onMessage(Message message) {
        try {
            ActiveMQObjectMessage objMessage = (ActiveMQObjectMessage) message;
            UserMoodPraiseRel rel = (UserMoodPraiseRel) objMessage.getObject();
            redisTemplate.opsForSet().add(REDIS_SET_KEY_PRAISE, rel.getMoodId());
            redisTemplate.opsForSet().add(rel.getMoodId(), rel.getUserId());
            logger.info("$Mood Consumer$: userId[{}] praise moodId[{}]", rel.getUserId(), rel.getMoodId());
        } catch (Exception e) {
            logger.warn("Mood Consumer failed to consume message.", e);
        }
    }
}
