package com.scblock.wxchat.service;

import com.scblock.wxchat.entity.Example;
import com.scblock.wxchat.mapper.ExampleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:08
 * @Description: 考试服务接口
 */
public interface ExampleService {
    /**
     * @Description: 插入新的考题,成功返回受影响的行数,失败返回0
     * @author: sunyubin
     * @Date 2020/4/18 20:37
     * @Param [em]
     * @Return int
     */
    int insert(Example em);

    /**
     * @Description: 批量插入新的考题,成功返回受影响的行数,失败返回0
     * @author: sunyubin
     * @Date 2020/4/18 20:38
     * @Param [exmps]
     * @Return int
     */
    int batchInsert(List<Example> exmps);
    /**
     * @Description: 随机获取count条数据, 返回试题的集合
     * @author: sunyubin
     * @Date 2020/4/18 21:33
     * @Param [count]
     * @Return java.util.List<com.scblock.wxchat.entity.Example>
     */
    List<Example> getExampleForRandom(int count);
}
