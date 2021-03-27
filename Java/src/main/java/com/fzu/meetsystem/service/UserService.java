package com.fzu.meetsystem.service;


import com.fzu.meetsystem.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //用户注册
    public boolean registerUser(String username, String password, List<Integer> meetingIdList);
    //通过用户名获取用户信息
    public User getUserInfo(String username);
    //获取近time个分钟内注册的人数，每min分钟一个点
    public List<Integer> getRegisterUserNumber(Integer time,Integer min);
}
