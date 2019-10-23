package com.dz.test;

import org.junit.Test;

import java.sql.*;

public class test {

    @Test
    public void test(){
        //有返回值参数
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///mybook","root","root");
            CallableStatement cs = conn.prepareCall("{CALL insert_getId(?,?,?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2,"Rose");
            cs.setString(3,"qwe");
            cs.executeUpdate();
            int id = cs.getInt(1);
            System.out.println("刚刚插入的Id：" + id);
            cs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //无参数返回结果集
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql:///mybook","root","root");
            CallableStatement cs = conn.prepareCall("{CALL find_user()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()) {
                String name = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("name:"+ name +"\tpassword:"+ password);
            }
            rs.close();
            cs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        //有参数无返回值
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql:///mybook","root","root");
            CallableStatement cs = connection.prepareCall("{CALL insert_user(?,?)}");
            cs.setString(1,"dz");
            cs.setString(2,"root");
            int rows = cs.executeUpdate();
            System.out.println(rows);
            cs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
