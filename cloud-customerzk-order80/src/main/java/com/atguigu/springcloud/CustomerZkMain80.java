package com.atguigu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-18 20:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CustomerZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CustomerZkMain80.class, args);
    }
}
