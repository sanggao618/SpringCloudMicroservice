package com.atguigu.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author sanggao
 * @create 2022-01-18 17:47
 */

@Configuration
@MapperScan({"com.atguigu.cloudalibaba.dao"})
public class MyBatisConfig {
}


