package com.example.soft3.Service;

import com.example.soft3.Mapper.UserInfoMapper;
import com.example.soft3.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SchoolMateServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findUserInfoList_Service() {
        return userInfoMapper.findUserInfoList();
    }
    @Override
    public UserInfo login(String username, String password) {
        return userInfoMapper.login(username, password);
    }

    @Override
    public List<UserInfo> findbyid(Integer id){
        return userInfoMapper.findByid(id);
    }

    @Override
    public List<UserInfo> findusername(String username){return userInfoMapper.findUsername(username);}

    @Override
    public List<UserInfo> find_userinfo_by_name_Servic(String username) {
        return userInfoMapper.find_userinfo_by_name_Servic(username);
    }

    @Override
    public int user_Register_Servic(UserInfo userInfo) {
        return userInfoMapper.user_Register_Servic(userInfo);
    }
}
