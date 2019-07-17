package com.qf.j1902.service;

import com.qf.j1902.pojo.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/27.
 */
public interface UserService {

    //定义一个获取所有用户的方法
    ArrayList<User> getUsers();
    //定义一个 添加用户的方法
    boolean addUser(User user);
    boolean delUser(int id);

}
