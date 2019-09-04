package com.atguigu.gmall.controller;

import com.atguigu.gmall.UserInfo;
import com.atguigu.gmall.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


 @GetMapping("indAll")
    public List<UserInfo> findAll(){
        List<UserInfo> userInfoList = userInfoService.getUserInfoList();
        return userInfoList;
    }
}
