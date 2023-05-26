package com.example.soft3.Model;

public class UserInfo {
    private Integer id;
    private String userName;

    private String password;
    private String sex;
    private String nativePlace;
    private String hobby;
    private String username;
    private String nativeplace;

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public UserInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getId() {
        return id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +
                ", userName'" + userName + '\'' +
                ", userPassword'" + password + '\'' +
                ", userSex'" + sex + '\'' +
                ", userNativePlace'" + nativePlace + '\'' +
                ", userHobby'" + hobby + '\'' +
                '}';
    }
}
