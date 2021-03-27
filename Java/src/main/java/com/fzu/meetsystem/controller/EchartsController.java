package com.fzu.meetsystem.controller;

import com.fzu.meetsystem.mapper.UserDao;
import com.fzu.meetsystem.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.security.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/api")
public class EchartsController {
    @Autowired
    MeetingService meetingService;
    @Autowired
    UserDao userDao;
    @GetMapping("/bar_graph")
    @ResponseBody
    public Map<String,Object> getBarGraph(@RequestBody(required = false) Map<String,Object>data, HttpServletRequest http, Principal principal){
        HashMap<String, Object> resp = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(userDao.selectAllUser());
        arr.add(meetingService.getUserNumber(1));
        arr.add(meetingService.getUserNumber(2));
        arr.add(meetingService.getUserNumber(3));
        resp.put("list",arr);
        return resp;
    }
    @GetMapping("/line_graph")
    @ResponseBody
    public Map<String,Object> getLineGraph(@RequestBody(required = false) Map<String,Object>data, HttpServletRequest http, Principal principal){
        HashMap<String, Object> resp = new HashMap<>();
//        List<Map<String,Object>> arr = new ArrayList<>();
//        new Timestamp(System.currentTimeMillis())
//        userDao.countRegisterUserByTime();
//        resp.put("list",arr);
        return resp;
    }
}
