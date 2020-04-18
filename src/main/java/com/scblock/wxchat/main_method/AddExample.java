package com.scblock.wxchat.main_method;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.google.common.collect.Maps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/18 20:16
 * @Description: 考题添加
 */
public class AddExample {


    public static void main(String[] args) throws Exception {
        Map<String, String> properties = Maps.newHashMap();
        properties.put("driverClassName", "com.mysql.jdbc.Driver");
        properties.put("url","jdbc:mysql://49.233.76.240:3306/example");
        properties.put("username","root");
        properties.put("password", "Syb930725");
        DruidDataSource dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//        System.out.println(dds);
        Connection connection = dds.getConnection();
        PreparedStatement ps = null;
        try {

            for(int i= 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    String sql = "INSERT INTO example(problem, answer, create_time) VALUES(?,?,?)";
                    ps = connection.prepareStatement(sql);
                    String exprsion = i + " + " + j + " =";
                    String ans = (i+j) + "";
                    ps.setString(1, exprsion);
                    ps.setString(2, ans);
                    ps.setString(3, LocalDateTime.now().toString());
                    ps.executeUpdate();

                }
                System.out.println("成功!");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ps.close();
            connection.close();
            dds.close();
        }
    }

}
