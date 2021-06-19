package com.atguigu.springcloud.service;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-06-19 15:54
 */
public interface IPaymentService {

    /**
     *  正常方法
     * @param id
     * @return
     */
    String paymentInfo(Integer id);

    /**
     * 模拟会出错
     *    程序运行异常
     *    超时
     *    服务熔断触发服务降级
     *    线程池、信号量打满
     * @param id
     * @return
     */
    String paymentInfoError(Integer id);


    /**
     * 熔断机制
     * @param id
     * @return
     */
    String paymentCircuitBreak(Integer id);
}
