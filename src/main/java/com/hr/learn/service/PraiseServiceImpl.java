package com.hr.learn.service;

import com.hr.learn.mapper.PraiseMapper;
import com.hr.learn.model.praise.Mood;
import com.hr.learn.model.praise.MoodVO;
import com.hr.learn.model.praise.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 * @date 19-6-2 星期日 17:23
 **/
@Service
public class PraiseServiceImpl implements PraiseServiceI {
    private static final Logger logger = LoggerFactory.getLogger(PraiseServiceImpl.class);

    @Resource
    private PraiseMapper praiseMapper;

    @Override
    public List<MoodVO> queryMood() {
        List<Mood> lstMood = praiseMapper.queryMood();

        List<MoodVO> lstMoodVO = new ArrayList<>(lstMood.size());
        for (Mood mood : lstMood) {
            MoodVO moodVO = new MoodVO();
            moodVO.setId(mood.getId());
            moodVO.setContent(mood.getContent());
            moodVO.setPraiseNum(mood.getPraiseNum());
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
}
