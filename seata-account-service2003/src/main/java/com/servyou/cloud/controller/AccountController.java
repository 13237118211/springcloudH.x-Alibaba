package com.servyou.cloud.controller;

import com.servyou.cloud.domain.CommonResult;
import com.servyou.cloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/account/deduction")
    public CommonResult deduction(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.deduction(userId,money);
        return new CommonResult(200,"扣除账户成功");
    }
}
