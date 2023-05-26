package com.example.soft3;

import com.example.soft3.Service.SchoolMateServiceImpl;
import com.example.soft3.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserInfoService SchoolMateServiceImpl;

    @PostMapping("/gologin")

    public String gologin(@RequestParam("name") String username, @RequestParam("password") String password , HttpSession session) {
//        if ("李贺".equals(username) && "123".equals(password)) {
//            //return "这是RestController控制方式，"+ username+ "，登录 成功";
//            session.setAttribute("currentuser",username);
//            return "publicpage";
//        }
        if (SchoolMateServiceImpl.login(username,password) != null)

        {
            session.setAttribute("currentuser",username);
            return "publicpage";
        }
        else {
            //return "这是RestController控制方式，" + username + "，用户名或密码有误，请重新输入！";
            return "login_fail";
        }
    }


}

