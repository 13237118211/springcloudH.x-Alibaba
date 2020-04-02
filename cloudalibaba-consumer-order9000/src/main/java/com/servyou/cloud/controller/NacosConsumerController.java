package com.servyou.cloud.controller;



import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class NacosConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;


    @GetMapping("/consumer/payment/nacos/info")
    @SentinelResource(value = "nacos",blockHandler = "blockHandler")
    public String paymentInfo(){
        return restTemplate.getForObject(serviceUrl+"/payment/nacos/info",String.class);
    }

    public String blockHandler(BlockException blockException){
        return "hotKeyHandler";
    }

}
