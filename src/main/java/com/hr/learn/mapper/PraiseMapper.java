package com.hr.learn.mapper;

import com.hr.learn.model.praise.Mood;
import com.hr.learn.model.praise.User;
import com.hr.learn.model.praise.UserMoodPraiseRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author nick
 * @date 19-6-2 星期日 11:26
 **/
public interface PraiseMapper {
    User getUser(String id);

    List<Mood> queryMood();

    Mood getMood(@Param("id") String id);

    int updateMood(@Param("mood") Mood mood);

    int addUserMoodPraiseRel(@Param("rel") UserMoodPraiseRel rel);
}
