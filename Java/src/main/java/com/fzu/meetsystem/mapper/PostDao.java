package com.fzu.meetsystem.mapper;

import com.fzu.meetsystem.pojo.Post;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface PostDao {
    /*发布消息*/
    void insertPost(Post post);
    /*查询该论坛下的消息,分页*/
    List<Post> selectAllPostsByMeetId(Integer meetId,Integer page,Integer limit);
    /*查找时间戳之后的对应会议Id的 消息列表,分页*/
    List<Post> getNewPost(Integer meetId, Timestamp timestamp,Integer page,Integer limit);
}
