package com.hr.learn.jms;

import com.hr.learn.model.praise.UserMoodPraiseRel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author nick
 * date 2019-06-07 星期五 22:36
 **/
@Component
public class MoodProducer {
    private static final Logger logger = LoggerFactory.getLogger(MoodProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final UserMoodPraiseRel rel) {
        logger.info("*Mood Producer*: userId[{}] praise moodId[{}]", rel.getUserId(), rel.getMoodId());

        jmsTemplate.convertAndSend(destination, rel);
    }
}
