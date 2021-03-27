package com.fzu.meetsystem.controller;

import com.fzu.meetsystem.pojo.User;
import com.fzu.meetsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String,Object>user,HttpServletRequest http, Principal principal){
        HashMap<String, Object> data = new HashMap<>();
        String username = (String) user.get("username");
        String password = (String) user.get("password");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate;
        try{
            authenticate = authenticationManager.authenticate(token);
        }catch (BadCredentialsException b){
            data.put("_msg","failed");
            return data;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        User userInfo = userService.getUserInfo(username);
        //
        //改成获取权限名
        //
        data.put("authority",userInfo.getAuthorityId());
        return data;
    }
    @PostMapping("/register")
    @ResponseBody
    public Map<String,Object> register(@RequestBody Map<String,Object>user,HttpServletRequest http, Principal principal){
        HashMap<String, Object> resp = new HashMap<>();
        boolean flag;
        try{
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            List<Integer> meetIdList = (List<Integer>) user.get("meetIdArray");
            flag = userService.registerUser(username, password, meetIdList);
        }catch (Exception e){
            resp.put("_msg","failed");
            return resp;
        }

        if(!flag)
            resp.put("_msg","failed");
        return resp;
    }
    @RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> logout(@RequestBody(required = false) Map<String,Object>user,HttpServletRequest http, Principal principal){
        SecurityContextHolder.clearContext();
        return null;
    }

}
