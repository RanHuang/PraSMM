package com.hr.learn.service;

import com.hr.learn.model.praise.MoodVO;

import java.util.List;

/**
 * @author nick
 * @date 19-6-2 星期日 17:18
 **/
public interface PraiseServiceI {
    List<MoodVO> queryMood();
}
