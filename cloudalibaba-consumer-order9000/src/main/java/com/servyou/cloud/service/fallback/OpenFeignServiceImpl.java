package com.servyou.cloud.service.fallback;

import com.servyou.cloud.service.OpenFeignService;
import org.springframework.stereotype.Component;

@Component
public class OpenFeignServiceImpl implements OpenFeignService {
    @Override
    public String provider() {
        return "服务降级";
    }
}
