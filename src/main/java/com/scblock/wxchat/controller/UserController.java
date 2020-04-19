package com.scblock.wxchat.controller;

import com.alibaba.druid.util.StringUtils;
import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:10
 * @Description: 用户控制器
 */
@RestController
@RequestMapping("/usr")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bcpe;

    @Autowired
    private UserService us;

    @GetMapping("/hi")
    public ResultMsg he(){
        return ResultMsg.success(ResultEnum.SUCCESS);
    }

    @PostMapping("/addUser")
    public ResultMsg insertUser(String phone, String password){
        if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            return ResultMsg.error(ResultEnum.PARAMETER_ERROR);
        }
        String newPassword = bcpe.encode(password);
        int flag = 0;
        try {
            flag = us.insert(phone, password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return flag == 0 ? ResultMsg.error(ResultEnum.USER_REPET) : ResultMsg.success();
    }
}
