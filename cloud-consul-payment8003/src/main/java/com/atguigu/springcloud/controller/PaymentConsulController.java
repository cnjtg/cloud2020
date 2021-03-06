package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author cnjtg
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("payment/consul")
    public Object consul() {
        return "Springcloud with consul: " + serverPort + "\t" + UUID.randomUUID();
    }
}
