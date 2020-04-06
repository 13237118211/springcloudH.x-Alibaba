package com.servyou.cloud.service.impl;

import com.servyou.cloud.domain.CommonResult;
import com.servyou.cloud.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountServiceFallback implements AccountService
{
    @Override
    public CommonResult deduction(Long userId, BigDecimal money) {
        return new CommonResult(400,"账户服务报错降级");
    }
}
