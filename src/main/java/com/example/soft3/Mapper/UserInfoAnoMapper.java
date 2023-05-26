package com.example.soft3.Mapper;

import com.example.soft3.Model.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoAnoMapper {
    @Select("select * from userinfo where id = #{id}")
    UserInfo findUserInfoById(Integer id);

    @Insert("insert into userinfo (username, password, sex, nativeplace, hobby) values(#{username}, #{password}, #{sex}, #{nativeplace}, #{hobby})")
    public void insert(String username, String password, String sex, String nativeplace, String hobby);

    @Delete("delete from userinfo where id = #{id}")
    void deleteUserInfo(Integer id);

    @Update("update userinfo set username = #{username}, password = #{password}, sex = #{sex}, nativeplace = #{nativeplace}, hobby = #{hobby} where id = #{id}")
    void updateUserInfo(String username, String password, String sex, String nativeplace, String hobby, Integer id);
}
