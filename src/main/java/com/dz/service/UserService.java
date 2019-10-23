package com.dz.service;

import com.dz.dao.UserDao;
import com.dz.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void save(User user){
        userDao.save(user);
    }

    public List<User> findByPage() {
        PageHelper.startPage(1, 3);
        return userDao.findByPage();
    }
    public PageInfo<User> findByPage2() {
        PageHelper.startPage(1, 3);
        List<User> users = userDao.findByPage();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        //pageInfo.setList(users);
        return pageInfo;
    }
}
