package com.atguigu.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.UserAddress;
import com.atguigu.gmall.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Reference
    UserInfoService userService;
    @RequestMapping("trade")
    @ResponseBody // 第一个返回json 字符串，fastJson.jar 第二直接将数据显示到页面！
    public List<UserAddress> trade(String userId){
        // 返回一个视图名称叫index.html
        return userService.getUserAddressList(userId);
    }
}
