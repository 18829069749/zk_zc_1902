package com.qf.j1902.controller;

import com.google.gson.Gson;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.ManagerService;
import com.qf.j1902.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/5/29.
 */
@Controller
public class XiuGaiController {
    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;


    @RequestMapping(value="edit{id}",method= RequestMethod.GET)
    public String upone(@RequestParam(value = "id") int id, Model model) {

        Manager oneMana = managerService.getOneMana(id);
        String name=oneMana.getName();
         String password=oneMana.getPassword();
         String email=oneMana.getEmail();
         model.addAttribute("id",id);
         model.addAttribute("name",name);
        model.addAttribute("password",password);
        model.addAttribute("email",email);

        return "edit";
    }
    @RequestMapping(value="edit2",method= RequestMethod.GET)
    public String upone2( @RequestParam(value="id")int id,
                           @RequestParam(value="uname")String name,
                         @RequestParam(value="upw")String password,
                         @RequestParam(value = "email")String email,
                         Model model) {
        Manager mana = new Manager();
        mana.setId(id);
        mana.setName(name);
        mana.setPassword(password);
        mana.setEmail(email);

        boolean b = managerService.upManager(mana);
        if (b){

            return "user";
        }else{
            model.addAttribute("success2","修改失败");
            model.addAttribute("id",id);
            model.addAttribute("name",name);
            model.addAttribute("password",password);
            model.addAttribute("email",email);
            return "edit";
        }

    }

}
