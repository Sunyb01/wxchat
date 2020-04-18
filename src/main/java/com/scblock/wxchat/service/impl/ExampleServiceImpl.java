package com.scblock.wxchat.service.impl;

import com.scblock.wxchat.entity.Example;
import com.scblock.wxchat.exception.InsertDataException;
import com.scblock.wxchat.mapper.ExampleMapper;
import com.scblock.wxchat.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:09
 * @Description: 考试服务实现类
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleMapper epm;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int insert(Example em) {
        int flag = epm.insert(em);
        if (0 == flag){
            throw  new InsertDataException();
        }
        return flag;
    }

    @Override
    public int batchInsert(List<Example> exmps) {

        int flag = epm.batchInset(exmps);
        if (0 == flag) {
            throw new InsertDataException();
        }
        return flag;
    }

    @Override
    public List<Example> getExampleForRandom(int count) {
        if(0 == count) {
            count = 5;
        }
        List<Example> lists = epm.getExampleForRandom(count);
        if(CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<>();
        }
        return lists;
    }
}
