package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 15:45
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderHystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixDashboardMain9001.class, args);
    }
}
