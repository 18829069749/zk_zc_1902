package com.qf.j1902.controller;

import com.google.gson.Gson;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.ManagerService;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/31.
 */
@Controller
public class ZscController {
    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;


    @RequestMapping(value="add1",method= RequestMethod.GET)
    public String add() {
        return "add";
    }

    @RequestMapping(value="addtwo",method=RequestMethod.GET)
    public String addtwo(
            @RequestParam(value="name")String name,
            @RequestParam(value="password")String password,
            @RequestParam(value = "email")String email) {
        ArrayList<Manager> all =managerService.getManagers();
        for (Manager manager :all ) {
            System.out.println(manager);
            if (manager.getName().equals(name)&&manager.getPassword().equals(password) &&manager.getEmail().equals(email)){
                return"add";
            }else{
                Manager m = new Manager();
                m.setName(name);
                m.setPassword(password);
                m.setEmail(email);
                managerService.addManager2(m);
                System.out.println(m);
                return "user";

            }
        }
        return "user";
    }


    @RequestMapping(value="user1",method=RequestMethod.GET)
    public String user() {
        return "user";
    }


    @RequestMapping(value="cha",method=RequestMethod.GET)
    public String userone(  HttpServletResponse response) throws IOException {

        ArrayList<Manager> managers = managerService.getManagers();
        String json = new Gson().toJson(managers);

        PrintWriter out = response.getWriter();
        out.write(json);

        out.close();

        return "user";
    }


//    @RequestMapping(value="del",method=RequestMethod.GET)
//    @ResponseBody
//    public String delone( HttpServletResponse response , @RequestParam(value="id")int id) throws IOException {
//
//
//
//        System.out.println(id);
//        boolean b = managerService.delManager(id);
//        if(b){
//           return"success";
//        }else{
//            return "fail";
//        }
//
//    }
    @RequestMapping(value="chaxun1",method= RequestMethod.GET)
    public String upone2(@RequestParam(value="name")String name, HttpServletResponse response) throws IOException {

        ArrayList<Manager> managerone = managerService.findManagerone(name);
        String json = new Gson().toJson(managerone);
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();
        return "user";
    }

}
