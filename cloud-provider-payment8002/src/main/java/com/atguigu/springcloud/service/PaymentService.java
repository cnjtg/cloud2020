package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entites.Payment;

public interface PaymentService {

    int save(String serial);

    Payment get(Long id);
}
