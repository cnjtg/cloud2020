package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 15:53
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentHystrixController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    //#############################服务降级###################################

    @GetMapping("/info/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo(id);
        log.info("*********result:" + s);
        return s;
    }

    @GetMapping("/error/{id}")
    public String paymentInfoError(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfoError(id);
        log.info("*********result:" + s);
        return s;
    }


    //#############################服务熔断###################################
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentCircuitBreak(id);

        log.info("*******result: " + result);
        return result;
    }
}
