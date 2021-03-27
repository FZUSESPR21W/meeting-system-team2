package com.fzu.meetsystem.service;


import com.fzu.meetsystem.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
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
    List<Map<String,Object>> getMeetList(String username);
    //通过会议id获取参会者人数
    Integer getUserNumber(Integer meetId);
    //通过会议id获取参会者信息
    List<User> getUserInfo(Integer meetId);
    //通过用户名和用户对应的会议idList让用户加入会议
    boolean joinMeetings(String username,List<Integer> meetIdList);
    //通过秘书名字得到会议id
    Integer getMeetingIdByName(String username);
}
