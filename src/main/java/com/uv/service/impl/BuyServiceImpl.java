package com.uv.service.impl;
/*
 * @author uv
 * @date 2018/10/12 10:50
 *
 */

import com.uv.service.BuyService;

public class BuyServiceImpl implements BuyService{

    @Override
    public void buy(String name) {
        System.out.println("buy " + name);
    }
}
