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
    @Autowired
    UserDao userDao;

    @Override
    public List<Map<String, Object>> getMeetList(String username) {
        List<Map<String, Object>> meetings = new ArrayList<>();
        for (Meeting meeting : meetingDao.selectAllMeets(username)) {
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
        return userDao.selectUserByMeetId(meetId);
    }

    @Override
    public boolean joinMeetings(String username, List<Integer> meetIdList) {
        List<Meeting> hadAttendMeet = meetingDao.selectAllMeets(username);
        Integer user_id = userDao.selectUserByUsername(username).getId();

        boolean isAttendNewMeet = false;

        for (int meet_id : meetIdList) {
            for (Meeting meeting : hadAttendMeet) {
                if (meeting.getId() == meet_id)
                    continue;
                else {
                    userDao.insertUserWithMeet(user_id, meet_id);
                    isAttendNewMeet = true;
                }
            }
        }
        return isAttendNewMeet;
    }

}
