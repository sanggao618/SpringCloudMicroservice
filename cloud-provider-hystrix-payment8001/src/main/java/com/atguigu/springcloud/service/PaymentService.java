package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author sanggao
 * @create 2022-01-12 17:54
 */

@Service
public class PaymentService {

    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {

        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t";
    }

    /**
     * 异常、超时访问，演示降级，调用兜底方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") //设置超时时间
    })
    public String paymentInfo_TimeOut(Integer id) {

        int age = 10 / 0; //模拟异常
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"耗费5秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {

        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id: "+id+"，支付服务不可用！";
    }

    /* ======================服务熔断====================== */

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口大小
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率
            // 在10秒（一个时间窗口）内接收10次请求，若发生异常6次及以上则服务熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        if(id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID(); //等价于UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {

        return "id不能为负数，请稍后再试！id:" +id;
    }
}

