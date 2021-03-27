package com.fzu.meetsystem.service;

import com.fzu.meetsystem.mapper.MeetingDao;
import com.fzu.meetsystem.mapper.UserDao;
import com.fzu.meetsystem.pojo.Meeting;
import com.fzu.meetsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    MeetingDao meetingDao;
    UserDao userDao;

    @Override
    public List<Map<String, Object>> getMeetList() {
        List<Map<String, Object>> meetings = new ArrayList<>();
        for (Meeting meeting : meetingDao.selectAllMeets()) {
            Map<String, Object> m = new HashMap<>();

            m.put("id", meeting.getId());
            m.put("chairman_name", userDao.selectUserById(meeting.getChairmanId()).getUserName());
            m.put("secretary_name", userDao.selectUserById(meeting.getSecretaryId()).getUserName());
            m.put("name", meeting.getName());
            m.put("context", meeting.getContent());

            meetings.add(m);
        }
        return meetings;
    }

    @Override
    public Integer getUserNumber(Integer meetId) {
        return meetingDao.countAll(meetId);
    }

    @Override
    public List<User> getUserInfo(Integer meetId) {
        return userDao.selectUserIdByMeetId(meetId);
    }

    @Override
    public boolean joinMeetings(String username, List<Integer> meetIdList) {
        List<Meeting> hadAttendMeet = userDao.selectAllMeetsByUserId(username);
        Integer user_id = userDao.selectUserByUsername(username).getId();

        boolean isIn = false;
        boolean isSame = false;

        for (int meet_id : meetIdList) {
            for (Meeting meeting : hadAttendMeet) {
                //新会议在已参加列表
                if (meet_id == meeting.getId()) {
                    isIn = true;
                    break;
                }
            }
            //新会议不在已参加列表
            if (!isIn)
                //加入列表
                userDao.insertUserWithMeet(user_id, meet_id);
            else
                isIn = false;
        }

        //更新已参加列表
        hadAttendMeet = userDao.selectAllMeetsByUserId(username);

        for (Meeting meeting : hadAttendMeet) {
            for (int meet_id : meetIdList) {
                if (meeting.getId() == meet_id) {
                    isSame = true;
                    break;
                }
            }
            if (!isSame)
                //该方法将status:1->0
                userDao.deleteUserWithMeet(user_id, meeting.getId());
            else
                isSame = false;
        }
        return true;
    }

}
