package com.atguigu.springcloud.lb;

import cn.hutool.core.lang.Console;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-18 22:03
 */
@Component
public class MyLb implements LoadBalanced {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current,next));
        Console.log("************第几次访问next: {}",next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> services) {
        int index = getAndIncrement()%services.size();
        return services.get(index);
    }
}
