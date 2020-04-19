package com.scblock.wxchat.mapper;

import com.scblock.wxchat.entity.Rule;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 11:08
 * @Description: 权限映射接口
 */
public interface RuleMapper {

    /**
     * @Description: 根据用户信息查询用户权限
     * @author: sunyubin
     * @Date 2020/4/19 11:10
     * @Param [id]
     * @Return com.scblock.wxchat.entity.Rule
     */
    Rule findRulesById(@Param("userId") int id);
}
