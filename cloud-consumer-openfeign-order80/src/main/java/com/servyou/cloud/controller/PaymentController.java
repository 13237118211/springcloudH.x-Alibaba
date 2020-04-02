package com.servyou.cloud.controller;

import com.servyou.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "consumer/payment/consul")
    //@HystrixCommand(fallbackMethod = "paymentConsulFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String paymentConsul(){
        return paymentFeignService.paymentConsul();
    }

//    public String paymentConsulFallback(){
//        return "调用支付服务出错或自身程序有问题";
//    }

    //测试熔断机制
    @RequestMapping(value = "consumer/payment/circuit/consul/{id}")
    public String paymentCircuitConsul(@PathVariable Integer id){
        return paymentFeignService.paymentCircuitConsul(id);
    }

    //测试zipkin
    @GetMapping(value = "consumer/payment/zipkin")
    public String zipkin(){
        return paymentFeignService.zipkin();
    }
}
