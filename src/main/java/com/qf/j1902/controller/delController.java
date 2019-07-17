package com.qf.j1902.controller;

import com.qf.j1902.service.ManagerService;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/6/4.
 */
@Controller
public class delController {
    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;



    @RequestMapping(value="del",method= RequestMethod.GET)
    @ResponseBody
    public String delone(HttpServletResponse response , @RequestParam(value="id")int id) throws IOException {



        System.out.println(id);
        boolean b = managerService.delManager(id);
        if(b){
            return"success";
        }else{
            return "fail";
        }

    }
}
