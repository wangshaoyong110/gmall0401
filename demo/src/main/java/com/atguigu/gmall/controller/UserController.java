package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("addUser")
    public  String  addUser(  UserInfo userInfo){
        userService.addUser(userInfo);
        return "success";
    }

    @GetMapping("allUser")
    public List<UserInfo> getAllUser(){
        return  userService.getUserInfoListAll();
    }

    @GetMapping("userInfo")
    public UserInfo getUser(String id){
        return  userService.getUserInfo(id);
    }

    @PostMapping("delUser")
    public String deleteUser(UserInfo userInfo){
        userService.delUser(userInfo);
        return  "success";
    }

    @PostMapping("updateUser")
    public String updateUser(UserInfo userInfo){
        //  userService.updateUser(userInfo);

        userService.updateUserByName(userInfo.getName(),userInfo);
        return  "success";
    }
}