package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Manager;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.UserService;
import com.qf.j1902.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/27.
 */
public class MapperTest {
    @Test
    public void Test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ManagerMapper managerMapper = ac.getBean(ManagerMapper.class);
        ArrayList<Manager> all = managerMapper.getManagers();
        for (Manager manager :all ) {
            System.out.println(manager);
        }

    }

    @Test
    public void Test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = ac.getBean(UserMapper.class);
        ArrayList<User> all = userMapper.getUsers();

        for (User user :all ) {
            System.out.println(user);
        }

    }



}
