package com.atguigu.springcloud.filter;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-21 11:35
 */
@Component
public class GateWayFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器
     *
     * @param exchange 交换
     * @param chain    链
     * @return {@link Mono<Void>}
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Console.log("***************come in GlobalFilter :{}", DateUtil.now());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            Console.log("**** uname为空");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 得到顺序
     *
     * @return int
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
