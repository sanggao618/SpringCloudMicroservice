package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sanggao
 * @create 2022-01-17 9:39
 */

@RestController
public class SendMessageController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {

        return messageProvider.send();
    }

}
