package com.fzu.meetsystem.service;

import com.fzu.meetsystem.pojo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    //通过用户名、会议id获取对应的文章，如果为null，不用该条件
    //page代表当前页面数，limit代表单页数量，null不限制
    public List<Post> getPostList(Integer meetId,Integer page,Integer limit);
    //发送消息，并通知对应用户
    public boolean sendPost(String username,Post post);

}
