package com.qf.j1902.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/5/31.
 */
@Controller
public class RenZhengController {
//
    @RequestMapping(value="accttype",method= RequestMethod.GET)
    public String renz() {
        return "accttype";
    }



    @RequestMapping(value="leixing",method= RequestMethod.POST)
    public String renz2(@RequestParam(value = "action") String rztype, HttpSession session) {
        session.setAttribute("renzhengLx",rztype);
     return "accttype";
    }

    @RequestMapping(value="aa",method= RequestMethod.POST)
    @ResponseBody
      public String applyone( HttpSession session) {
        String renzhengLx = (String)session.getAttribute("renzhengLx");
        if(renzhengLx!=null){
            return "success";
        }else {
            return "fails";
        }

    }
//
}
