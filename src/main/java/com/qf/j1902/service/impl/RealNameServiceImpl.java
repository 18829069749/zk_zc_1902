package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.RealNameMapper;
import com.qf.j1902.service.RealNameService;
import com.qf.j1902.vo.RealName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
@Service
public class RealNameServiceImpl implements RealNameService {
    @Autowired
    private RealNameMapper realNameMapper;
    @Override
    public void addRealName(RealName realName) {
        realNameMapper.addRealName(realName);
    }

    @Override
    public List<RealName> findAll() {
        List<RealName> all = realNameMapper.findAll();
        return all;
    }

    @Override
    public RealName findOneById(int id) {
        RealName oneById = realNameMapper.findOneById(id);
        return oneById;
    }

    @Override
    public void updateById(RealName realName) {

        realNameMapper.updateById(realName);
    }

    @Override
    public void delRealNameById(int id) {

        realNameMapper.delRealNameById(id);
    }

    @Override
    public RealName findOneByUser(String username) {
        RealName oneByUser = realNameMapper.findOneByUser(username);
        return oneByUser;
    }
}
