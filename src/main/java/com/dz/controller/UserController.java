package com.dz.controller;

import com.dz.pojo.User;
import com.dz.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public String save(){
        User user = new User();
        user.setUsername("Jerry");
        user.setPassword("qwe");
        userService.save(user);
        return "user/success";
    }
    @RequestMapping("findByPage")

    public @ResponseBody List<User> findByPage(){
        return userService.findByPage();
    }

    @RequestMapping("findByPage2")
    @ResponseBody
    public PageInfo<User> findByPage2(){
        return userService.findByPage2();
    }
}
