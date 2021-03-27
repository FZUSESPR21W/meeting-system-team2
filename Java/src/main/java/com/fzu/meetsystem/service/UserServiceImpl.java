package com.fzu.meetsystem.service;

import com.fzu.meetsystem.mapper.UserDao;
import com.fzu.meetsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    //用户注册
    @Override
    public boolean registerUser(String username, String password, List<Integer> meetingIdList) {
        boolean success = false;
        if (userDao.selectUserByUsername(username) == null) {
            User user = new User();
            user.setUserName(username);
            user.setPassWord(password);
            user.setAuthorityId(1);
            if (userDao.insertUser(user)){
                user = userDao.selectUserByUsername(username);
                Integer userId = user.getId();
                for (Integer meetingId:
                     meetingIdList) {
                    userDao.insertUserWithMeet(userId,meetingId);
                }
                success = true;
            }
        }
        return success;
    }

    @Override
    public User getUserInfo(String username) {
        return userDao.selectUserByUsername(username);
    }

    @Override
    public List<Integer> getRegisterUserNumber(Integer time, Integer min) {
        List<Integer> list = new ArrayList<>();
        long current = new Date().getTime();
        long start = current - time;
        while (start < current){
            list.add(userDao.countRegisterUserByTime(new Timestamp(start), new Timestamp(start + min)));
            start += min;
        }
        return list;
    }
}
