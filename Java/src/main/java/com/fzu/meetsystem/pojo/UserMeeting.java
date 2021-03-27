package com.fzu.meetsystem.pojo;


import java.sql.Timestamp;

public class UserMeeting {

    private Integer id;
    private Integer userId;
    private Integer meetingId;
    private Timestamp time;
    private Integer status;
    private Integer hasNew;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHasNew() {
        return hasNew;
    }

    public void setHasNew(Integer hasNew) {
        this.hasNew = hasNew;
    }
}
