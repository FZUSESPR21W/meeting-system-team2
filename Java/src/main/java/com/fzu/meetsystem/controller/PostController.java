package com.fzu.meetsystem.controller;

import com.fzu.meetsystem.pojo.Post;
import com.fzu.meetsystem.service.MeetingService;
import com.fzu.meetsystem.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
@Tag(name = "用户接口")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    MeetingService meetingService;
    @ResponseBody
    @PostMapping("/addPost")
    public void addPost(@RequestBody Map<String,Object> data,HttpServletRequest http, Principal principal){
        String username=String.valueOf(data.get("username"));
        String title=String.valueOf(data.get("title"));
        String context=String.valueOf(data.get("context"));
        Integer meetingId=meetingService.getMeetingIdByName(username);
        Post post=new Post();
        post.setTitle(title);
        post.setContext(context);
        post.setMeetingId(meetingId);
        postService.sendPost(username,post);
    }
    @ResponseBody
    @PostMapping("/getPostList")
    public Map<String,Object> getPostList(@RequestBody Map<String,Object> data,HttpServletRequest http, Principal principal){
        Map<String, Object> resp= new HashMap<>();
        String username = principal.getName();
        Integer meetId = (Integer) data.get("meetId");
        Integer page = (Integer) data.get("page");
        Integer limit = (Integer) data.get("limit");
        List<Post> postList = postService.getPostList(meetId, username, page, limit);
        resp.put("postList",postList);
        return resp;
    }
}
