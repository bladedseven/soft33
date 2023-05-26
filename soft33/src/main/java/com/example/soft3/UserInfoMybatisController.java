package com.example.soft3;

import com.example.soft3.Model.UserInfo;
import com.example.soft3.Service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoMybatisController {

    @Autowired
    private UserInfoService userInfoService;

    @ResponseBody
    @GetMapping("/MyBatis_userinfo_list")
    public List<UserInfo> MyBatisUserInfoList(Model model) {
        List<UserInfo> userInfoList = userInfoService.findUserInfoList_Service();
        model.addAttribute("Result", userInfoList);
        return userInfoList;
    }


    @GetMapping("/MyBatis_userinfo_list_page")
    public String MyBatisUserInfoListPage(Model model) {
        List<UserInfo> userInfoList = userInfoService.findUserInfoList_Service();
        model.addAttribute("Result", userInfoList);
        return "result";
    }

    @ResponseBody
    @GetMapping("/gobyid/{id}")
    public List<UserInfo> gobyid(@PathVariable int id, Model m) {
        List<UserInfo> UserList = userInfoService.findbyid(id);
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @GetMapping("/gobyid_Page/{id}")
    public String gobyid_Page(@PathVariable int id, Model m) {
        List<UserInfo> UserList = userInfoService.findbyid(id);
        m.addAttribute("Result", UserList);
        return "result";
    }

    @ResponseBody
    @GetMapping("/gousername/{username}")
    public List<UserInfo> gousername(@PathVariable String username, Model m) {
        List<UserInfo> UserList = userInfoService.findusername(username);
        m.addAttribute("Result", UserList);
        return UserList;
    }

    @GetMapping("/gousername_Page/{username}")
    public String gousername_Page(@PathVariable String username, Model m) {
        List<UserInfo> UserList = userInfoService.findusername(username);
        m.addAttribute("Result", UserList);
        return "result";

    }
}
