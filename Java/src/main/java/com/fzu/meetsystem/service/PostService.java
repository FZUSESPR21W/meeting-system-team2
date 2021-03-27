package com.fzu.meetsystem.service;

import com.fzu.meetsystem.pojo.Post;

import java.util.List;

public interface PostService {
    //通过用户名、会议id获取对应的文章，如果为null，不用该条件
    //page代表当前页面数，limit代表单页数量，null不限制
    public List<Post> getPostList(String username,Integer meetId,Integer page,Integer limit);
    //发送消息，并通知对应用户
    public boolean sendPost(String username,String context,Integer meetId);
    //获取未读文章，并更新最后一次阅读时间
    public List<Post> getUnreadPost(String username);
    //获取未读文章数量
    public Integer getUnreadNumber(String username);

}
