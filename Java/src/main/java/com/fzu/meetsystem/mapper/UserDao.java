package com.fzu.meetsystem.mapper;

import com.fzu.meetsystem.pojo.Meeting;
import com.fzu.meetsystem.pojo.Post;
import com.fzu.meetsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /*用户注册*/
    boolean insertUser(User user);
    /*增加用户-分论坛关联(1条)*/
    void insertUserWithMeet(Integer userId,Integer meetId);
    /*通过用户名查用户*/
    User selectUserByUsername(String username);
    /*获得所有的分论坛id,用于用户注册时的复选框列表*/
    List<Integer> selectAllMeetId();
    /*统计所有用户*/
    Integer selectAllUser();






}
