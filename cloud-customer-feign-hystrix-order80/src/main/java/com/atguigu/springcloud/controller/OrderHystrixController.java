package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 16:53
 */
@RestController
@Slf4j
@RequestMapping("/customer")
@DefaultProperties(defaultFallback = "paymentGlobalFallBack")
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @HystrixCommand
    @GetMapping("/payment/info/{id}")
    public String info(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfo(id);
        int a = 10/0;
        return s;
    }




    @GetMapping("/payment/error/{id}")
    @HystrixCommand(fallbackMethod = "errorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000"),
    })
    public String error(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfoError(id);

        return s;
    }

    public String errorHandler(Integer id){

        return "服务端烦忙，请稍后再试!id: "+id;
    }

    public String paymentGlobalFallBack(){
        return "全局响应超时，请稍后！";
    }
}
