package com.uv.service.impl;
/*
 * @author liuwei
 * @date 2018/10/12 14:37
 * 没有实现任何接口的被代理类
 */

public class SayService {
    public void say(String name) {
        System.out.println("Hello " + name);
    }
}
