package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-18 21:38
 */
@Configuration
public class SelfRule {
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }

}
