package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanggao
 * @create 2022-01-12 17:55
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //默认兜底方法
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {

        String result = paymentService.paymentInfo_OK(id);
        log.info("result: "+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") //设置超时时间
//    })
    @HystrixCommand //Controller类上面加了@DefaultProperties注解，并且没有写具体方法名字，就调用全局的兜底方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) throws InterruptedException {

        int age = 10 / 0; //模拟异常
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("result: "+result);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {

        return "支付服务繁忙，请稍后再试";
    }

    public String payment_Global_FallbackMethod() {

        return "全局异常处理信息：请稍后再试";
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("result: "+result);
        return result;
    }
}
