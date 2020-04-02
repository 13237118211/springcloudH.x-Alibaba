package com.servyou.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayMentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "payment/consul")
    public String paymentConsul() {
        //测试openfeign客户端调用服务连接超时
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SpringCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
    @RequestMapping(value = "payment/circuit/consul/{id}")
    public String paymentCircuitConsul(@PathVariable Integer id) {
        //测试openfeign客户端调用服务出错触发熔断机制
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        return "SpringCloud with consul:" + id + "\t" + UUID.randomUUID().toString();
    }

    @GetMapping("payment/zipkin")
    public String zipkin(){
        return "yes! im zipkin~~";
    }
}
