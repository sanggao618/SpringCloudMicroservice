package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sanggao
 * @create 2022-01-11 10:43
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    //@Autowired
    @Resource //属性注入
    private PaymentDao paymentDao;

    public int create(Payment payment) {

        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {

        return paymentDao.getPaymentById(id);
    }
}
