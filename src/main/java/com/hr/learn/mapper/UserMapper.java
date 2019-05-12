package com.hr.learn.mapper;

import com.hr.learn.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nick
 * @date 19-5-12 星期日 22:59
 **/
@Repository
public interface UserMapper {
    List<User> findAll();
}
