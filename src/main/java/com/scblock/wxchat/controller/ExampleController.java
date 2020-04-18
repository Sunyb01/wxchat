package com.scblock.wxchat.controller;

import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.entity.Example;
import com.scblock.wxchat.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:10
 * @Description: 考试服务控制类
 */
@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private ExampleService ems;

    @GetMapping("/getExamples")
    public ResultMsg getExamples(Integer count){
        if (Objects.isNull(count) || 0 == count) {
            count = 5;
        }
        List<Example> lists = ems.getExampleForRandom(count);
        return ResultMsg.success(lists);
    }
}
