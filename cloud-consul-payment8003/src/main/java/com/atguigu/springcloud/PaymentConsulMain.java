package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cnjtg
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain.class, args);
    }
}
