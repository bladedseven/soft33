package com.example.soft3;

import com.example.soft3.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @GetMapping("/Helloo")
    public String index(){
        return "hello";
    }
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/getdata")
    public List<Map<String, Object>> searchData(Model model) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from userinfo");
        return list;
    }

    @GetMapping("/datalist")
    public String getDataList(Model model){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select *from userinfo");
        model.addAttribute("Result", list);
        System.out.println(list);
        return "result";
    }
    @ResponseBody
    @GetMapping("/getuserinfo")
    public List<UserInfo> getUserInfo(){
        String sql = "select * from userinfo";
        BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
        List<UserInfo> list = jdbcTemplate.query(sql, rowMapper);
        System.out.println(list);
        return list;
    }
    @GetMapping("/getuserlist")
    public String getUserList(Model model){
        String sql = "select * from userinfo";
        BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
        List<UserInfo> list = jdbcTemplate.query(sql, rowMapper);
        System.out.println(list);
        model.addAttribute("Result", list);
        return "result";
    }


}
