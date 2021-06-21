package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author cnjtg
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discover")
    public Object discover() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******service = " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("*******instance = " + instance.getServiceId() +"\t" +instance.getHost()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb/{id}")
    public String lb(@PathVariable("id")Integer id){
        return serverPort+" id:"+ id;
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
