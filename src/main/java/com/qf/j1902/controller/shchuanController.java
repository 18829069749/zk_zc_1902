package com.qf.j1902.controller;

import com.qf.j1902.service.RealNameService;
import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.RealName;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019/6/2.
 */
@Controller
public class shchuanController {

//    @RequestMapping(value="/apply-2", method= RequestMethod.POST)
//    public String upload(
////            @RequestParam(value = "realname") String realname,
////                               @RequestParam(value = "cardnum") String cardnum,
////                               @RequestParam(value = "tel") String tel,
//            @RequestParam(value = "feil") MultipartFile file, HttpServletRequest request ,HttpSession session){
//
////        ModelAndView mv=new ModelAndView();
//
//        System.out.println("9999999999999");
//        System.out.println(file);
//        String path = request.getSession().getServletContext().getRealPath("upload");
//
//        String fileName = file.getOriginalFilename();
//        String location = "upload/" + fileName;
//        String location1 = path+"\\"+fileName;
//
//        File file1 =new File(location1);
//
//        System.out.println(location1);
//        try {
//            file1.createNewFile();
//            file.transferTo(file1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        mv.addObject("location",location);
//        session.setAttribute("location",location);
////        mv.addObject("realname",realname);
////        mv.addObject("cardnum",cardnum);
////        mv.addObject("tel",tel);
////        mv.setViewName("apply-2");
//        return "apply-2";
////        return mv;
//    }

          @Autowired
           private RealNameService realNameService;

    @RequestMapping(value = "/sqwc",method = RequestMethod.POST)
    public String sqjg(@RequestParam(value = "audit",defaultValue = "审核中") String audit,
                       HttpServletRequest request,Model model,
                       HttpSession session){

        String realyzm = request.getParameter("realyzm");
        System.out.println(realyzm);
        String yzm = (String)request.getSession().getAttribute("SessionKey");
        System.out.println(yzm);
        if (realyzm.equals(yzm)){
            String name = (String)session.getAttribute("username");
            String rzType = (String)session.getAttribute("renzhengLx");
            String realname = (String)session.getAttribute("realname");
            String cardnum = (String)session.getAttribute("cardnum");
            String tel = (String)session.getAttribute("tel");
            String email =(String) session.getAttribute("email");
            String crudimg =(String) session.getAttribute("crudimg");
            String[] rzzt={"未通过审核","审核中","已审核"};
            String zhuangtai=rzzt[1];
            System.out.println(realyzm+"::"+email+":--:"+tel+":--:"+cardnum+":--:"+realname+":--:"+rzType+":--:"+crudimg+"---"+name);
           model.addAttribute("zhuangtai",zhuangtai);
           RealName r = new RealName();
           r.setCardimg(crudimg);
           r.setCardnum(cardnum);
            r.setEmail(email);
            r.setRealName(realname);
            r.setRzType(rzType);
            r.setTel(tel);
            r.setZhuangtai(zhuangtai);
            r.setName(name);
            realNameService.addRealName(r);

            return "/member";
        }else{

            model.addAttribute("yzmcu","验证码错误");
            return "/apply-3";
        }


    }
    @RequestMapping(value = "/apply-2", method = RequestMethod.POST)
    public String upload(
            MultipartFile file,
            HttpServletRequest request,
            HttpSession session) {

        System.out.println(file);
//        String path = request.getRealPath("upload");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();

        String location1 = "/upload"+ fileName;
        String location2 = path+"\\"+ fileName;
        System.out.println(location2);
        session.setAttribute("crudimg",location2);
        File f1 = new File(location2);

//        String location = path + fileName;
//        System.out.println(location);
//        File f = new File(location);

        try {
            f1.createNewFile();
            file.transferTo(f1);
//            f.createNewFile();
//            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "apply-2";
    }


    @RequestMapping(value = "sendyzm", method = RequestMethod.POST)
    @ResponseBody
    public int yxyz(HttpServletRequest request, @RequestParam(defaultValue = "a") String exam) {
        String regEx1 = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(exam);
        if (m.matches()) {
            try {
                HtmlEmail htmlEmail = new HtmlEmail();
                htmlEmail.setHostName("smtp.163.com");
                htmlEmail.setCharset("utf-8");
                htmlEmail.addTo(exam);
                htmlEmail.setFrom("zt970509@163.com", "众筹系统");
                htmlEmail.setAuthentication("zt970509@163.com", "zhangting123");
                htmlEmail.setSubject("实名认证验证码");
                int a = (int) ((Math.random() * 9 + 1) * 100000);
                String aa = String.valueOf(a);
                HttpSession session = request.getSession();
                session.setAttribute("SessionKey", aa);
                htmlEmail.setMsg("尊贵的会员：您的验证码为" + "<h3>" + aa + "</h3>");
                htmlEmail.send();
            } catch (EmailException e) {
                e.printStackTrace();
            }
            return 200;
        }else {
            return 400;
        }


        }


    }
