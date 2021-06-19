package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("insert")
    public CommonResult<Payment> insert(@RequestBody Payment payment) {
        int res = paymentService.save(payment.getSerial());
        if (res > 0) {
            return new CommonResult(200, "成功", res);
        }
        return new CommonResult(500, "失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.get(id);
        log.info("server.port", serverPort);
        if (payment == null) {
            return new CommonResult(500, "未找到,0_0");
        }
        return new CommonResult<>(200, "成功" + serverPort, payment);
    }
    @GetMapping("/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
