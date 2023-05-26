package com.example.soft3.repository;

import com.example.soft3.Model.UserInfoJPABean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserInfoJPARepository extends JpaRepository<UserInfoJPABean, Integer> {
    List findByUserName(String username);
    List findByNativePlace(String nativeplace);
//    @Query(value = "select * from userinfo where sex=?1 order by id asc ", nativeQuery = true)
//    List<UserInfoJPABean> findBySex(String sex);
    @Query(value = "select u from userinfo u where u.Sex = ?1 order by u.id desc ", nativeQuery = false)
    List<UserInfoJPABean> findBySex(String sex);
    @Transactional
    @Modifying
    @Query(value = "insert into userinfo(username, password, sex, nativeplace, hobby) value(?1, ?2, ?3, ?4 ,?5)", nativeQuery = true)
    int insertUser(String username,String password, String sex, String nativeplace,String hobby);

    @Transactional
    @Modifying
    @Query(value = "delete from userinfo u where u.userName = ?1", nativeQuery = false)
    int deleteUserByName(String username);

    @Transactional
    @Modifying
    @Query(value = "update  userinfo u set u.hobby = ?2 where u.userName = ?1", nativeQuery = false)
    void updateUserByName(String username, String hobby);
}
