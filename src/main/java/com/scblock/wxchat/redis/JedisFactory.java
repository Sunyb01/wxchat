package com.scblock.wxchat.redis;

import redis.clients.jedis.Jedis;

/**
 * @Author: sunyubin
 * @Date: 2020/1/6 15:33
 * @Description: jedis工厂类
 */
public class JedisFactory {

    private volatile static Jedis jedis;

    private JedisFactory() {}

    public static Jedis getJedisInstance() {
        if (jedis == null) {
            synchronized (jedis) {
                if (jedis == null) {
                    jedis = new Jedis();
                }
            }
        }
        return jedis;
    }
}
