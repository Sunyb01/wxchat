package com.scblock.wxchat.controller;

import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:10
 * @Description: 用户控制器
 */
@RestController
@RequestMapping("/usr")
public class UserController {
    @GetMapping("/hi")
    public ResultMsg he(){
        return ResultMsg.success(ResultEnum.SUCCESS);
    }
}
