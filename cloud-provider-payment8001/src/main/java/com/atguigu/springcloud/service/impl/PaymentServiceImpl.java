package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cnjtg
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;


    @Override
    public int save(String serial) {
        Payment payment = new Payment();
        payment.setSerial(serial);
        return paymentDao.save(payment);
    }

    @Override
    public Payment get(Long id) {
        return paymentDao.get(id);
    }
}
