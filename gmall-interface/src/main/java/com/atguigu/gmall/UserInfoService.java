package com.atguigu.gmall;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getUserInfoList();
    List<UserAddress> getUserAddressList(String userId);
}
