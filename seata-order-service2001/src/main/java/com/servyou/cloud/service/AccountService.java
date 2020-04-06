package com.servyou.cloud.service;

import com.servyou.cloud.domain.CommonResult;
import com.servyou.cloud.service.impl.AccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
@FeignClient(value = "seata-account-service",fallback = AccountServiceFallback.class)
public interface AccountService {

    @PostMapping("/account/deduction")
    CommonResult deduction(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
