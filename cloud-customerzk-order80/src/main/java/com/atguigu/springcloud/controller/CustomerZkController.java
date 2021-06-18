package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-18 20:13
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerZkController {


    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public String getMessage(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
