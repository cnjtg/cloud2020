package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-20 11:22
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Main {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Main.class, args);
    }
}
