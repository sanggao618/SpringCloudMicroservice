package com.atguigu.cloudalibaba.service;

/**
 * @author sanggao
 * @create 2022-01-18 17:38
 */

public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}