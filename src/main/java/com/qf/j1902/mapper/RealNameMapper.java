package com.qf.j1902.mapper;

import com.qf.j1902.vo.RealName;

import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface RealNameMapper {

    public void addRealName(RealName realName);

    public List<RealName> findAll();

    public RealName findOneById(int id);

    public void updateById(RealName realName);

    public void delRealNameById(int id);

    public RealName findOneByUser(String username);
}
