package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sanggao
 * @create 2022-01-12 15:00
 */

@Configuration
public class MyRule {

    @Bean
    public IRule randomRule() {

        return new RandomRule(); //随机访问规则
    }
}
