package com.atguigu.cloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;

/**
 * @author sanggao
 * @create 2022-01-18 11:57
 */

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){

        return new CommonResult(444,"自定义的限流处理信息：CustomerBlockHandler");
    }

}
