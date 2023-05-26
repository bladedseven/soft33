package com.example.soft3;

import com.example.soft3.Mapper.UserInfoAnoMapper;
import com.example.soft3.Model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@SpringBootTest
public class MngSysApplicationTests {

//    @Autowired(required = false)
//    JdbcTemplate jdbcTemplate;
//    @Test
//    public void selectUserId (){
//        String sql = "select *from userinfo where id = ?";
//        BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<>(UserInfo.class);
//        UserInfo user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
//        System.out.println(user);
//    }
//    @Test
//    public void insertUser() {
//        String sql = "insert into userinfo(username, password, sex, nativeplace, hobby) values('xixi','123', 'male', '洛杉矶', '乒乓球')";
//        jdbcTemplate.update(sql);
//        System.out.println("写入成功");
//    }
//    @Test
//    public void deleteUser() {
//        String sql = "delete from userinfo where username = 'xixi'";
//        jdbcTemplate.update(sql);
//        System.out.println("删除成功");
//    }
    @Autowired
    UserInfoAnoMapper userInfoAnoMapper;
    @Test
    public void selectUserId() {
        UserInfo user = userInfoAnoMapper.findUserInfoById(1);

        System.out.println(user);
    }
    @Test
    public void insertUser() {
        userInfoAnoMapper.insert("香肠","123","male","山东", "画画");

        System.out.println("写入成功");
    }

    @Test
    public void deleteUserId() {
        userInfoAnoMapper.deleteUserInfo(14);

        System.out.println("删除成功");
    }

    @Test
    public void updateUserId() {
        userInfoAnoMapper.updateUserInfo("香unun","123","男","山东", "画画",12);

        System.out.println("修改成功");
    }
}
