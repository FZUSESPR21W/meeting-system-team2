package com.fzu.meetsystem.service;


import com.fzu.meetsystem.mapper.UserDao;
import com.fzu.meetsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
class UserDetailsServiceImpl implements UserDetailsService {
    //注入UserRoleService，可以通过用户名查询用户信息和权限列表
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //MyUser为业务的用户实体类，可以获取用户名、密码，与t_user表对应
        User user = userDao.selectUserByUsername(username);
        //将以上信息转换为UserDetails
        UserDetails userDetails = changeToUserDetails(user);
        return userDetails;
    }
    private UserDetails changeToUserDetails(User user){
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassWord(),
                Collections.singleton(new SimpleGrantedAuthority(userDao.getAuthorityById(user.getAuthorityId()))));
        return userDetails;
    }
}
