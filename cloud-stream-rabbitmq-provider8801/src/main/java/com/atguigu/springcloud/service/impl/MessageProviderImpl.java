package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author sanggao
 * @create 2022-01-17 9:35
 */

@EnableBinding(Source.class) // 定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output; // 消息的发送管道

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serial).build()); // 创建并发送消息
        System.out.println("serial: "+serial);
        return serial;
    }
}
