package com.example.soft3;//package com.example.soft3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcOperations;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class GlxtApplicationTests {
    @Autowired
    DataSource datasource;
    @Test
    public void Dbtest() {

        Connection conn;
        try {

            conn = datasource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("连接失败!!!", e);
        }
        System.out.println(conn);
    }

    @Autowired(required = false)
    JdbcOperations jdbcTemplate;
    @Test
    public void setDatasource(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from userinfo");
        System.out.println(list);
    }
    @Test
    public void insertUser(){
        String sql = "insert into userinfo(username, password, sex, nativeplace, hobby) values('xxxx','123', 'male', '江苏','unun')";
        jdbcTemplate.update(sql);
        System.out.println("写入成功");
    }
    @Test
    public void deleteUser() {
        String sql = null;

        sql = "delete from userinfo where username='xxxx'";
        jdbcTemplate.update(sql);
        System.out.println("删除成功");
    }
    @Test
    public void updateUser(){
        String sql = "update userinfo set hobby='吃饭睡觉' where username = 'xxxx'";
        jdbcTemplate.update(sql);
        System.out.println("更新成功");
    }
}



//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class GlxtApplicationTests {
//    static String driverClass = "oracle.jdbc.driver.OracleDriver"; //oracle的驱动
//    static String url = "jdbc:oracle:thin:@127.0.0.1:1521:mytest"; //连接oracle路径方式 ”DataBaseName“是要建立连接的数据库名 1521端口
//    static String user = "root";//数据库的用户名
//    static String password = "666888"; //用户登录密码
//
//    public static Connection getconn() {//为了方便下面的讲解，这里专门建立了一个用于数据库连接的一个方法
//        Connection conn = null;
//        try {
//
//            //首先建立驱动
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            //驱动成功后进行连接
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println(conn);
//
//            System.out.println("连接成功");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn; //返回一个连接
//    }
//    public static void main(String[] args){
//        getconn();
//    }
//}