package com.atguigu.cloudalibaba.service;

import com.atguigu.cloudalibaba.domain.Order;

/**
 * @author sanggao
 * @create 2022-01-18 17:18
 */

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}