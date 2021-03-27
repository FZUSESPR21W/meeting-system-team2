package com.fzu.meetsystem.mapper;

import com.fzu.meetsystem.pojo.Meeting;
import com.fzu.meetsystem.pojo.Post;
import com.fzu.meetsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserDao {
    /*用户注册*/
    boolean insertUser(User user);
    /*增加用户-分论坛关联(1条)*/
    void insertUserWithMeet(Integer userId,Integer meetId);
    /*通过用户名查用户*/
    User selectUserByUsername(String username);
    /*通过Id查询用户*/
    User selectUserById(Integer id);
    /*获得所有的分论坛id,用于用户注册时的复选框列表*/
    List<Integer> selectAllMeetId();
    /*统计所有用户*/
    Integer selectAllUser();
    /*通过权限id获取权限名称*/
    String getAuthorityById(Integer authorityId);
    /*通过分论坛的id获得该论坛下的用户实体列表(status为1的用户)*/
    List<User> selectUserByMeetId(Integer meetId);
    /*获得一个时间区间内的注册人数*/
    Integer countRegisterUserByTime(Timestamp start,Timestamp end);
    /*阅读之后修改阅读状态,1->0*/
    void readNews(Integer meetId,Integer userId);
}
