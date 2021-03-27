package com.fzu.meetsystem.service;


import com.fzu.meetsystem.pojo.User;

import java.util.List;
import java.util.Map;

public interface MeetingService {
    //获取会议列表

    /**
     * map结构
     * {
     *      id:Number
     *      chairman_name:String
     *      secretary_name:String
     *      name:String
     *      context:String
     * }
     */
    public List<Map<String,Object>> getMeetList();
    //通过会议id获取参会者人数
    public Integer getUserNumber(Integer meetId);
    //通过会议id获取参会者信息
    public List<User> getUserInfo(Integer meetId);
    //通过用户名和用户对应的会议idList让用户加入会议
    public boolean joinMeetings(String username,List<Integer> meetIdList);
}
