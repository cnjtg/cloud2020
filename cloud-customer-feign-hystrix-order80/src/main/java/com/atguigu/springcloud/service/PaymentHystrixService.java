package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 16:50
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class   )
public interface PaymentHystrixService {

    @GetMapping("payment/info/{id}")
    String paymentInfo(@PathVariable("id") Integer id);


    @GetMapping("payment/error/{id}")
    String paymentInfoError(@PathVariable("id") Integer id);
}
