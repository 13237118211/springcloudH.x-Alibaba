package com.servyou.cloud.service;

import com.servyou.cloud.service.fallback.OpenFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-provider-server",fallback = OpenFeignServiceImpl.class)
public interface OpenFeignService {

    @GetMapping("/payment/nacos/info")
    String provider();
}
