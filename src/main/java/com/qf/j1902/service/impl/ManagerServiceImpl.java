package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.ManagerMapper;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/27.
 */
@Controller
public class ManagerServiceImpl implements ManagerService{

   @Autowired
   private ManagerMapper managerMapper;


    @Override
    public ArrayList<Manager> getManagers() {
        ArrayList<Manager> manager = managerMapper.getManagers();
        return manager;
    }

    @Override
    public boolean addManager(Manager manager) {

        return  managerMapper.addManager(manager);
    }

    @Override
    public boolean addManager2(Manager manager) {
        return managerMapper.addManager(manager);
    }

    @Override
    public boolean delManager(int id) {

        return managerMapper.delManager(id);
    }

    @Override
    public Manager getOneMana(int id) {
        return managerMapper.getOneMana(id);
    }

    @Override
    public boolean upManager(Manager manager) {

        return managerMapper.upManager(manager);
    }

    @Override
    public ArrayList<Manager> findManagerone(String name) {
        return managerMapper.findManagerone(name);
    }
}
