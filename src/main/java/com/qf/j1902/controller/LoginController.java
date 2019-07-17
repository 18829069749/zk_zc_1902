package com.qf.j1902.controller;

import com.google.gson.Gson;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.pojo.User;
import com.qf.j1902.service.ManagerService;
import com.qf.j1902.service.RealNameService;
import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.RealName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27.
 */
@Controller
public class LoginController {
//    @RequestMapping(value="deng",method=RequestMethod.POST)
//     @ResponseBody
//    public String index(@RequestParam(value="uname")String username,
//                        @RequestParam(value="upw")String password,
//                        @RequestParam(value="hui") String va) {
////        va=new String(va.getBytes("GB18030"),"utf-8");
//        System.out.println(va);
//        System.out.println(username);
//        return  username;
//    }

    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private RealNameService realNameService;
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String lshouye() {
        return "index";
    }
    @RequestMapping(value="login",method=RequestMethod.GET)
    public String loginf() {
        return "login";
    }
    @RequestMapping(value="reg",method=RequestMethod.GET)
    public String regf() {
        return "reg";
    }

    @RequestMapping(value="deng",method=RequestMethod.GET)
    public String index1(@RequestParam(value="uname")String name,
                         @RequestParam(value="upw")String password,
                         HttpSession session) {

        ArrayList<Manager> all =managerService.getManagers();
        for (Manager manager :all ) {
            if (manager.getName().equals(name)&&manager.getPassword().equals(password)){
                session.setAttribute("managernow",manager);
                return "main";
            }
        }
        return "reg";

    }
    @RequestMapping(value="lu",method=RequestMethod.GET)
    public String index2(@RequestParam(value="uname")String name,
                        @RequestParam(value="upw")String password,
                         Model model,
                         HttpSession session)
                          {

        ArrayList<User> all = userService.getUsers();

        for (User user :all ) {
//            System.out.println(user);

            if (user.getName().equals(name)&&user.getPassword().equals(password)){
                session.setAttribute("usernow",user);
                session.setAttribute("username",user.getName());
                RealName oneByUser = realNameService.findOneByUser(name);
                String zhuangtai=null;
                if(oneByUser!=null){
                    zhuangtai = oneByUser.getZhuangtai();
                    model.addAttribute("zhuangtai",zhuangtai);
                }else{
                    zhuangtai = "未实名认证";
                    model.addAttribute("zhuangtai",zhuangtai);
                }

                System.out.println(zhuangtai);
                model.addAttribute("username",name);
                System.out.println(name);
                return "member";
            }
        }
        return "reg";
    }



//    @RequestMapping(value="user1",method=RequestMethod.GET)
//    public String user() {
//        return "user";
//    }
//
//
//    @RequestMapping(value="cha",method=RequestMethod.GET)
//    public String userone(  HttpServletResponse response) throws IOException {
//
//        ArrayList<Manager> managers = managerService.getManagers();
//        String json = new Gson().toJson(managers);
//
//         PrintWriter out = response.getWriter();
//         out.write(json);
//
//        out.close();
//
//        return "user";
//    }
//
//
//    @RequestMapping(value="del",method=RequestMethod.GET)
//    @ResponseBody
//    public String delone( HttpServletResponse response , @RequestParam(value="id")int id) throws IOException {
//
//
//        System.out.println(id);
//        boolean b = managerService.delManager(id);
//        if(b){
//            return "success";
//        }else{
//            return "fail";
//        }
//    }

    @RequestMapping(value="auth_cert",method=RequestMethod.GET)
    public String authCert() {
        return "auth_cert";
    }

    @RequestMapping(value="getcert",method=RequestMethod.GET)

    public String userone(  HttpServletResponse response) throws IOException {

        List<RealName> realNames = realNameService.findAll();
        response.setContentType("text/html;charset=utf-8");
        String json2 = new Gson().toJson(realNames);
        System.out.println(json2);

        PrintWriter out = response.getWriter();
        out.write(json2);

        out.close();

        return "auth_cert" ;
    }
}
