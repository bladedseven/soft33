package com.example.soft3;

import com.example.soft3.Model.UserInfo;
import com.example.soft3.Service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/edituser")
//    public String editUser() {
//        return "edit_user";
//    }
    @GetMapping("/edituser")
    public String edituser(Model model) {
        List<UserInfo> UserList = (List<UserInfo>) userInfoService.findUserInfoList_Service();
        model.addAttribute("Result", UserList);
        return "edit_user";
    }
    @GetMapping("/deleteuserinfo/{id}")
    public String delUser(@PathVariable int id) {
        userInfoService.deleteUserInfo(id);
        return "redirect:/edituser";
    }

    @RequestMapping("/goupdate/{id}")
    public String goupdate(@PathVariable int id, Model model) {
        UserInfo user = userInfoService.findbyidd(id);
        model.addAttribute("user", user);
        return "updateuser";
    }
    @ResponseBody
    @PostMapping("/update")
    public int update(UserInfo users, @RequestParam(value = "id",required = false) int id, @RequestParam(value="name",required = false) String username,
                         @RequestParam(value = "password",required = false) String password
            , @RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "nativeplace", required = false) String nativeplace,
                         @RequestParam(value = "hobby", required = false) String hobby){
        users.setId(id);
        users.setUsername(username);
        users.setPassword(password);
        users.setSex(sex);
        users.setNativePlace(nativeplace);
        users.setHobby(hobby);
        userInfoService.updateUserInfoById(users);

        return 1;
    }
}
