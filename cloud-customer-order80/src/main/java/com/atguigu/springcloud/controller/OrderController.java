package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/customer")
public class OrderController {
//    public static final String PREFIX = "http://localhost:8001/";
    public static final String PREFIX = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable long id) {

        return restTemplate.getForObject(PREFIX + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/insert")
    public CommonResult insert(String serial) {
        Payment payment = new Payment();
        payment.setSerial(serial);
        return restTemplate.postForObject(PREFIX + "/payment/insert", payment, CommonResult.class);
    }
}
