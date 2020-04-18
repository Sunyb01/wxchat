package com.scblock.wxchat.mapper;

import com.scblock.wxchat.entity.Example;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:12
 * @Description: 考试实现类
 */
public interface ExampleMapper {
    /**
     * @Description: 添加新的考题,成功返回受影响的行数,失败返回0
     * @author: sunyubin
     * @Date 2020/4/18 20:25
     * @Param [example]
     * @Return int
     */
    int insert(Example example);
    /**
     * @Description: 批量插入考题,成功返回受影响的行数, 失败返回0
     * @author: sunyubin
     * @Date 2020/4/18 20:29
     * @Param [examples]
     * @Return int
     */
    int batchInset(@Param("exmps") List<Example> examples);

    /**
     * @Description: 随机获取count的试题
     * @author: sunyubin
     * @Date 2020/4/18 21:26
     * @Param []
     * @Return java.util.List<com.scblock.wxchat.entity.Example>
     */
    List<Example> getExampleForRandom(@Param("count")int count);
}
