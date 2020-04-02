package com.servyou.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nacos/info")
    public String provider(){
        return port + "info";
    }
}
