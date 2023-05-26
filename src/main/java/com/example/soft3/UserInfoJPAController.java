package com.example.soft3;

import com.example.soft3.Model.UserInfo;
import com.example.soft3.Model.UserInfoJPABean;
import com.example.soft3.repository.UserInfoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@Controller
public class UserInfoJPAController {
    @Autowired
    UserInfoJPARepository userInfoJPARepository;

    @ResponseBody
    @GetMapping("/uijpalist")
    public List<UserInfoJPABean> JPAList(Model model) {
        List<UserInfoJPABean> userList = userInfoJPARepository.findAll();
        model.addAttribute("Result", userList);
        return userList;
    }

    @ResponseBody
    @GetMapping("/jpa_find_userinfo_by_id/{id}")
    public Optional<UserInfoJPABean> JPAfindUserInfoById(@PathVariable int id, Model model) {
        Optional<UserInfoJPABean> user = userInfoJPARepository.findById(id);
        model.addAttribute("Result", user);
        return user;
    }


    @ResponseBody
    @GetMapping("/jpa_find_userinfo_by_username/{username}")
    public List<UserInfoJPABean> JPAfindUserInfoByUsername(@PathVariable String username){
        return (List<UserInfoJPABean>)  userInfoJPARepository.findByUserName(username);
    }
    @ResponseBody
    @GetMapping("/jpa_find_userinfo_by_nativeplace/{nativeplace}")
    public List<UserInfoJPABean> JPAfindUserInfoByNativeplace(@PathVariable String nativeplace){
        return (List<UserInfoJPABean>)  userInfoJPARepository.findByNativePlace(nativeplace);
    }

    @GetMapping("/jpa_find_userinfo_by_sex/{sex}")
    public String JPAfindUserInfoBySex(@PathVariable String sex, Model model) {
        List<UserInfoJPABean> userlist = userInfoJPARepository.findBySex(sex);
        model.addAttribute("Result", userlist);
        System.out.println(userlist);
        return "result";
    }

    @ResponseBody
    @GetMapping("/jap_insert_userinfo")
    public String JPAinsertUser() {
        userInfoJPARepository.insertUser("香肠","123","男","山东", "画画");
        return "写入成功";
    }

    @ResponseBody
    @GetMapping("/jap_delete_userinfo/{username}")
    public String JPAdeleteUser(@PathVariable String username) {
        userInfoJPARepository.deleteUserByName(username);
        return "删除成功";
    }

    @ResponseBody
    @GetMapping("/jap_update_userinfo/{username}&{hobby}")
    public String JPAupdateUser(@PathVariable String username,@PathVariable  String hobby) {
        userInfoJPARepository.updateUserByName(username,hobby);
        return "修改成功";
    }
    @ResponseBody
    @GetMapping("/UserInfo_JPA_Example")
    public List<UserInfoJPABean> JPA_Example() {
        UserInfoJPABean UIJpaBean = new UserInfoJPABean();
        UIJpaBean.setUserName("香");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<UserInfoJPABean> example = Example.of(UIJpaBean, exampleMatcher);
        List<UserInfoJPABean> userList = userInfoJPARepository.findAll(example);
        return userList;
    }
}
