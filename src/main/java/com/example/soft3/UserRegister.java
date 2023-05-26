package com.example.soft3;

import com.example.soft3.Model.UserInfo;
import com.example.soft3.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserRegister {
    @Autowired
    UserInfoService SchoolMateServiceImpl;
//    @PostMapping("/goregister")
//    public String goregister(@RequestParam("name") String username, @RequestParam("password") String password) {
//        System.out.println("name:" + username + ",password:" + password);
//        System.out.println("unununun");
//        return "username +password";
//
//    }
    @ResponseBody
    @PostMapping("/goregister")
    public int goregister(UserInfo userInfo, @RequestParam(value="name",required = false) String username, @RequestParam(value = "password",required = false) String password
            , @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "nativeplace", required = false) String nativeplace, @RequestParam(value = "hobby", required = false) String hobby){
        System.out.println("username:" + username + "\npassword:" + password + "\nsex:" + sex +"\nnativeplace" + nativeplace + "\nhobby" + hobby);
        if (SchoolMateServiceImpl.find_userinfo_by_name_Servic(username).isEmpty()){
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            userInfo.setSex(sex);
            userInfo.setNativePlace(nativeplace);
            userInfo.setHobby(hobby);
           SchoolMateServiceImpl.user_Register_Servic(userInfo);
            return 1;
        }
        else {
            System.out.println("该用户已存在!");
            return 0;
        }
    }
}
