package com.example.soft3.Mapper;

import com.example.soft3.Model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    List<UserInfo> findUserInfoList();

    UserInfo login (String username, String password);
    List<UserInfo> findByid(Integer id);

    List<UserInfo>findUsername(String username);
    public List<UserInfo> find_userinfo_by_name_Servic(String username );
    public int user_Register_Servic(UserInfo userInfo);
    public int deleteUserInfo(int id);
    UserInfo findbyidd(Integer id);
    int updateUserInfoById(UserInfo user);
}
