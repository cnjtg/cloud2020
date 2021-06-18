package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.lb.MyLb;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @Resource
    private MyLb myLb;

    @Resource
    private DiscoveryClient discoveryClient;

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


    /**
     * getForEntity 对象
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult getForEntity(@PathVariable long id) {

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PREFIX + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommonResult(400, "操作失败");
    }


    /**
     * postForEntity 对象
     *
     * @param serial
     * @return
     */
    @GetMapping("/payment/postForEntity")
    public CommonResult postForEntity(String serial) {
        Payment payment = new Payment();
        payment.setSerial(serial);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PREFIX + "/payment/insert", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommonResult(400, "操作失败");
    }


}
