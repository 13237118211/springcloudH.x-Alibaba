package com.servyou.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.servyou.cloud.service.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SentinelController {

    @GetMapping("/getA")
    public String getA(){
        return "A";
    }
    @GetMapping("/getB")
    public String getB(){
        return "B";
    }

    @GetMapping("/hotKey")
    //sentinel服务降级配置 value 一定要在sentinel控制台配置热点限流规则才能找到
    @SentinelResource(value = "hotKey",blockHandler = "hotKeyHandler")
    public String hotKey(@RequestParam(value = "p1",required = false) String p1){
        return "hotKey";
    }

    public String hotKeyHandler(String p1, BlockException blockException){
        return "hotKeyHandler";
    }


    //-----openfeign sentinel配置了服务限流后，当违反规则后会进入feign的fallback
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/nacos/fallback")
    public String fallback(){
       return openFeignService.provider();
    }
}
