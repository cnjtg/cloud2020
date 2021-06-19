package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 14:22
 */
@RestController
@Slf4j
@RequestMapping("/customer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        return paymentFeignService.get(id);

    }

    @GetMapping("/payment/timeout")
    public CommonResult timeout(){
        String port = paymentFeignService.timeout();
        return new CommonResult(200,port);
    }
}
