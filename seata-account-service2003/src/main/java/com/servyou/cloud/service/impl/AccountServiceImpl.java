package com.servyou.cloud.service.impl;

import com.servyou.cloud.dao.AccountDao;
import com.servyou.cloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void deduction(Long userId, BigDecimal money) {
        //测试服务降级
        int i = 10/0;
        accountDao.deduction(userId,money);
    }
}
