package com.hr.learn.mapper;

import com.context.ShowData;
import com.hr.learn.model.praise.Mood;
import com.hr.learn.model.praise.User;
import com.hr.learn.model.praise.UserMoodPraiseRel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author nick
 * @date 19-6-2 星期日 12:09
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:db-context.xml"})
public class PraiseMapperTest extends ShowData {
    @Autowired
    private PraiseMapper praiseMapper;

    @Test
    public void testGetUser() {
        String id = "1";
        User user = praiseMapper.getUser(id);
        Assert.assertNotNull(user);
        showData("User", user);
    }

    @Test
    public void testQueryMood() {
        List<Mood> lstMood = praiseMapper.queryMood();
        Assert.assertTrue(!lstMood.isEmpty());
        showData("Moods", lstMood);
    }

    @Test
    public void testSaveUserMoodPraiseRel() {
        UserMoodPraiseRel rel = new UserMoodPraiseRel();
        rel.setUserId("2");
        rel.setMoodId("2");
        int ret = praiseMapper.addUserMoodPraiseRel(rel);
        Assert.assertEquals(1, ret);
    }
}