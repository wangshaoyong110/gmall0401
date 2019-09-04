package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.mapper.UserInfoMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserInfoMapper userInfoMapper;
    
    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
        

    }

    @Override
    public void updateUser(UserInfo userInfo) {
        int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);
        int i = userInfoMapper.updateByExampleSelective(userInfo, example);
    }

    @Override
    public void delUser(UserInfo userInfo) {

        int i = userInfoMapper.deleteByPrimaryKey(userInfo);
    }

    @Override
    public UserInfo getUserInfo(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }
}
