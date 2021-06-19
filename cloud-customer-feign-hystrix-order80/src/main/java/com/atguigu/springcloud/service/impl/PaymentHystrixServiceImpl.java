package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 18:00
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo(Integer id) {
        return "---Payment Fall back-paymentInfo_OK ---";
    }

    @Override
    public String paymentInfoError(Integer id) {
        return "---Payment Fall back-paymentInfo_ERROR ---";
    }
}
