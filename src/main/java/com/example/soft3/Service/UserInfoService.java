package com.example.soft3.Service;

import com.example.soft3.Model.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> findUserInfoList_Service();
    UserInfo login(String username, String password);
    public List<UserInfo> findbyid(Integer id);

    public List<UserInfo> findusername(String username);

    public List<UserInfo> find_userinfo_by_name_Servic(String username );
    public int user_Register_Servic(UserInfo userInfo);
    public int deleteUserInfo(int id);
    public UserInfo findbyidd(Integer id);
    public int updateUserInfoById(UserInfo user);

}
