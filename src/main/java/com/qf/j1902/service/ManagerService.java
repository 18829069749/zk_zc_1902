package com.qf.j1902.service;

import com.qf.j1902.pojo.Manager;
import com.qf.j1902.pojo.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/27.
 */
public interface ManagerService {

    //定义一个获取所有用户的方法
    ArrayList<Manager> getManagers();
    //定义一个 添加用户的方法
    boolean addManager(Manager manager);
    boolean addManager2(Manager manager);
    //定义一个 删除用户的方法
    boolean delManager(int id);

    Manager  getOneMana(int id);
    boolean upManager(Manager manager);
    ArrayList<Manager>  findManagerone(String name);

}
