package com.fzu.meetsystem.mapper;

import com.fzu.meetsystem.pojo.Meeting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MeetingDao {
    /*获得所有分论坛列表,（主席/秘书）*/
    List<Meeting> selectAllMeets();
    /*通过分论坛Id获得分论坛人数*/
    Integer countAll(Integer meetId);
    /*通过用户名获得所有分论坛列表*/
    List<Meeting> selectAllMeetsByUserId(String username);
}
