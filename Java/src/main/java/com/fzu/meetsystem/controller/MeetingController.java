package com.fzu.meetsystem.controller;

import com.fzu.meetsystem.mapper.UserDao;
import com.fzu.meetsystem.pojo.Meeting;
import com.fzu.meetsystem.pojo.User;
import com.fzu.meetsystem.service.MeetingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Tag(name = "会议接口")
@RequestMapping("/api")
public class MeetingController {
    @Autowired
    MeetingService meetingService;
    @PostMapping("/meeting_list")
    @ResponseBody
    public Map<String,Object> getMeetingList(@RequestBody Map<String,Object>data,HttpServletRequest http, Principal principal){
        HashMap<String, Object> resp = new HashMap<>();
        String username=(String)data.get("username");
        if(username==null){
            resp.put("meetingList",meetingService.getAllMeetList());
        }else{

            resp.put("meetingList",meetingService.getMeetList(username));
        }
        return resp;
    }
    @ApiResponse(description = "秘书获取对应会议的人员信息，meetId为null，则返回全部")
    @RequestMapping(value = "/user_list",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> getUserList(@RequestBody Map<String,Object>data,HttpServletRequest http, Principal principal){
        HashMap<String, Object> resp = new HashMap<>();
        Integer meetId= (Integer) data.get("meetId");
        resp.put("userList",meetingService.getUserInfo(meetId));
        return resp;
    }
    @PostMapping(value = "/join_meeting")
    @ResponseBody
    public Map<String,Object> join_meeting(@RequestBody Map<String,Object>data,HttpServletRequest http, Principal principal){
        HashMap<String, Object> resp = new HashMap<>();
        String username = principal.getName();
        List<Integer> meetList = (List<Integer>) data.get("meetIdList");
        List<Integer>respList=new ArrayList<>();
        if(meetList==null){
            resp.put("_msg","failed");
            return resp;
        }
        for (int i = 0; i < meetList.size(); i++) {
            if(meetList.get(i)==1){
                respList.add(i);
            }
        }

        meetingService.joinMeetings(username,respList);
        return resp;
    }
}
