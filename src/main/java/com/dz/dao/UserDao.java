package com.dz.dao;

import com.dz.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    String SAVE_USER = "insert into t_user (username,password) values (#{username},#{password})";
    @Insert(SAVE_USER)
    void save(User user);

    @Select("select * from t_user")
    List<User> findByPage();
}
