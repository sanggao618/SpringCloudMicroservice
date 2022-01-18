package com.atguigu.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloudalibaba.handler.CustomerBlockHandler;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanggao
 * @create 2022-01-18 11:47
 */

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {

        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception) {

        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {

        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
        // 系统限流默认返回：Blocked by Sentinel (flow limiting)
    }

    /**
     * 自定义通用的限流处理逻辑
     * blockHandlerClass = CustomerBlockHandler.class
     * blockHandler = handleException2
     * 上述配置：找CustomerBlockHandler类里的handleException2方法进行兜底处理
     */
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handleException") //自定义兜底处理方法
    public CommonResult customerBlockHandler() {

        return new CommonResult(200,"按客户自定义限流处理逻辑");
    }

}
