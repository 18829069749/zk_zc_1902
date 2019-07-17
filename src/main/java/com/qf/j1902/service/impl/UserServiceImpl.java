package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.UserMapper;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/27.
 */
@Controller
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = userMapper.getUsers();
        return users;
    }

    @Override
    public boolean addUser(User user) {
        userMapper.addUser(user);
        return false;
    }

    @Override
    public boolean delUser(int id) {
        return userMapper.delUser(id);
    }
}
