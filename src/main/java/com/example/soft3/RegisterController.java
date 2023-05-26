package com.example.soft3;

import com.example.soft3.Model.UserInfo;
import com.example.soft3.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
//    @Autowired
//    UserInfoService SchoolMateServiceImpl;
    @GetMapping("/Register")
    public String login(){
        return "Register";
    }
//    @ResponseBody
//    @PostMapping("/goregister")
//    public int goregister(UserInfo userInfo, @RequestParam("username") String username, @RequestParam("password") String password
//            , @RequestParam("sex") String sex, @RequestParam("nativeplace") String nativeplace, @RequestParam("hobby") String hobby){
//        System.out.println("username:" + username + "\npassword:" + password + "\nsex:" + sex +"\nnativeplace" + nativeplace + "\nhobby" + hobby);
//        if (SchoolMateServiceImpl.find_userinfo_by_name_Servic(username).isEmpty()){
//            userInfo.setUserName(username);
//            userInfo.setPassword(password);
//            userInfo.setSex(sex);
//            userInfo.setNativePlace(nativeplace);
//            userInfo.setHobby(hobby);
//            SchoolMateServiceImpl.user_Register_Servic(userInfo);
//            return 1;
//        }
//        else {
//            System.out.println("该用户已存在!");
//            return 0;
//        }
//    }
}
