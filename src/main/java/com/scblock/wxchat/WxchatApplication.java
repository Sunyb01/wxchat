package com.scblock.wxchat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.scblock.wxchat.mapper")
@SpringBootApplication
public class WxchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxchatApplication.class, args);
    }

}
