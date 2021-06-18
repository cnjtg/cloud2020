package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cnjtg
 */
@Mapper
public interface PaymentDao {

    /**
     * 插入
     * @param payment
     * @return
     */
    int save(Payment payment);

    /**
     * 获取
     * @param id
     * @return
     */
    Payment get(Long id);


}
