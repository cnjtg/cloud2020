package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 15:55
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public String paymentInfo(Integer id) {

        return "线程池： " + Thread.currentThread().getName() + " paymentInfo,id: " + id + "\t" + "0_0";
    }

    //#############################服务降级###################################

    /**
     * @param id
     * @return
     * @HystrixCommand 指定降级时调用的类，
     * fallbackMethod 指定方法
     * commandProperties 指定降级的条件
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),})
    public String paymentInfoError(Integer id) {
        try {
            int a = 100 / 0;
            int s = 3000;
            TimeUnit.MILLISECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_Error,id: " + id + "\t" + "0_0";
    }


    public String paymentInfoTimeoutHandler(Integer id) {

        return "线程池： " + Thread.currentThread().getName() + " 8001系统繁忙，请稍后再试！,id: " + id + "\t" + "o(●'◡'●)o";
    }

    //#############################服务熔断###################################

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开户断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后熔断
    })
    public String paymentCircuitBreak(Integer id) {

        if (id < 0) {

            throw new RuntimeException("*****id 不能不于零");
        }
        String uuid = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功：" + uuid;
    }

    public String paymentCircuitBreakHandler(Integer id) {
        return "id 不能为负数，请稍后再试！/(ToT)/~~ id: " + id;
    }
}
