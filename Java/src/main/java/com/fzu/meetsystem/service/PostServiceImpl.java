package com.fzu.meetsystem.service;

import com.fzu.meetsystem.mapper.MeetingDao;
import com.fzu.meetsystem.mapper.PostDao;
import com.fzu.meetsystem.mapper.UserDao;
import com.fzu.meetsystem.pojo.Meeting;
import com.fzu.meetsystem.pojo.Post;
import com.fzu.meetsystem.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MeetingDao meetingDao;
    @Override
    public List<Post> getPostList(Integer meetId, Integer page, Integer limit) {
        List<Post> postList = postDao.selectAllPostsByMeetId(meetId, page, limit);
        return postList;
    }

    @Override
    public boolean sendPost(String username, Post post) {
        postDao.insertPost(post);
        List<Meeting> meetingList = meetingDao.selectAllMeets(username);
        postDao.pushNews(meetingList.get(0).getId());
        return true;
    }




}
