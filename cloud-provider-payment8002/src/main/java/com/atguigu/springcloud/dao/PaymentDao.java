package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 付款Dao
 *
 * @author cnjtg
 * @date 2021/06/20
 */
@Mapper
public interface PaymentDao {

    /**
     * 保存
     *
     * @param payment 付款
     * @return int
     */
    int save(Payment payment);

    /**
     * 得到
     *
     * @param id id
     * @return {@link Payment}
     */
    Payment get(Long id);


}
