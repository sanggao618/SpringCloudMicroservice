package com.atguigu.test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author sanggao
 * @create 2022-01-13 16:37
 */
public class ZonedDateTimeDemo {

    public static void main(String[] args) {

        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区的当前时间
        System.out.println(zbj);

        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 指定时区的当前时间
        System.out.println(zny);

    }
}
