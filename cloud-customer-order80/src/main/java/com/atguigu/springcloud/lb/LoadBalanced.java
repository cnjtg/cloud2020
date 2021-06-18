package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-18 22:01
 */
public interface LoadBalanced {

    ServiceInstance instances (List<ServiceInstance> services);
}
