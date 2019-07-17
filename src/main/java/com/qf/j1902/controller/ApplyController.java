package com.qf.j1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/5/31.
 */
@Controller
public class ApplyController {
    @RequestMapping(value="apply",method= RequestMethod.GET)
    public String apply() {
        return "apply";
    }
//    @RequestMapping(value="leixing",method= RequestMethod.POST)
//    public String renz2(@RequestParam(value = "action") String rztype, HttpSession session) {
//        session.setAttribute("renzhengLx",rztype);
//        return "apply";
//    }
    @RequestMapping(value="app1",method= RequestMethod.POST)
     @ResponseBody
    public String renz4(@RequestParam(value = "realname") String realname,
                        @RequestParam(value = "cardnum") String cardnum,
                        @RequestParam(value = "tel") String tel,
                        HttpSession session) {

        System.out.println("--"+realname+"---"+cardnum+"+++"+tel);
        session.setAttribute("realname",realname);
        session.setAttribute("cardnum",cardnum);
        session.setAttribute("tel",tel);


        if(realname!=null){
            return "success";
        }else {
            return "FAIL";
        }
//      return   "apply-1";

    }

    @RequestMapping(value="apply-1",method= RequestMethod.GET)
    public String applyone() {
        return "apply-1";

    }
    @RequestMapping(value="apply-3",method= RequestMethod.POST)
    public String applythree(HttpServletRequest request,HttpSession session) {

        String email = request.getParameter("email");
        session.setAttribute("email",email);
        return "apply-3";

    }
}

