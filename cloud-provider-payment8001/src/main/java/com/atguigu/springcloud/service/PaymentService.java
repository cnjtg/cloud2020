package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entites.Payment;

/**
 * @author cnjtg
 */
public interface PaymentService {

    /**
     * 保存
     *
     * @param serial 串行
     * @return int
     */
    int save(String serial);

    /**
     * 得到
     *
     * @param id id
     * @return {@link Payment}
     */
    Payment get(Long id);
}
