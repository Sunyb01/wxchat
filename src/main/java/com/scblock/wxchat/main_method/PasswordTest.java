package com.scblock.wxchat.main_method;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 21:34
 * @Description: ceshi
 */
public class PasswordTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String syb930725 = bCryptPasswordEncoder.encode("Syb930725");
        System.out.println(syb930725);
    }
}
