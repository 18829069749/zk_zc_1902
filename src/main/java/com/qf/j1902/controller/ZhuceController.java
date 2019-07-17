package com.qf.j1902.controller;

import com.qf.j1902.pojo.Manager;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.ManagerService;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/27.
 */
@Controller
public class ZhuceController {
    @Autowired
    private  UserService userService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value="zhu",method= RequestMethod.GET)
    public String zhuce1(@RequestParam(value="uname")String name,
                         @RequestParam(value="upw")String password,
                         @RequestParam(value = "mail")String email ) {
//        System.out.println(name);
//        System.out.println(password);
//        System.out.println(email);
        ArrayList<Manager> all =managerService.getManagers();
        for (Manager manager :all ) {
//            System.out.println(manager);
            if (manager.getName().equals(name)&&manager.getPassword().equals(password) &&manager.getEmail().equals(email)){
                return"login";
            }else{
                Manager m = new Manager();
                m.setName(name);
                m.setPassword(password);
                m.setEmail(email);
                managerService.addManager(m);
                System.out.println(m);
                return "index";
            }
        }
        return"index";
    }
    @RequestMapping(value="ze",method=RequestMethod.GET)
    public String zhuce2(@RequestParam(value="uname")String name,
                         @RequestParam(value="upw")String password,
                         @RequestParam(value = "mail")String email) {
        ArrayList<User> all = userService.getUsers();
        for (User user :all ) {
//            System.out.println(user);
            if (user.getName().equals(name)&&user.getPassword().equals(password) &&user.getEmail().equals(email)){
                return"login";
            }else{
                User u = new User();
                u.setName(name);
                u.setPassword(password);
                u.setEmail(email);
                userService.addUser(u);
//                System.out.println(users);
                return "index";
            }
        }
        return "index";
    }



//    @RequestMapping(value="add1",method=RequestMethod.GET)
//    public String add() {
//        return "add";
//    }
//
//    @RequestMapping(value="addtwo",method=RequestMethod.GET)
//    public String addtwo(
//            @RequestParam(value="name")String name,
//            @RequestParam(value="password")String password,
//            @RequestParam(value = "email")String email) {
//        ArrayList<Manager> all =managerService.getManagers();
//        for (Manager manager :all ) {
//         System.out.println(manager);
//            if (manager.getName().equals(name)&&manager.getPassword().equals(password) &&manager.getEmail().equals(email)){
//                return"add";
//            }else{
//
//                Manager m = new Manager();
//                m.setName(name);
//                m.setPassword(password);
//                m.setEmail(email);
//                managerService.addManager2(m);
//                System.out.println(m);
//                return "user";
//
//            }
//
//        }
//
//        return "add";
//    }



}
