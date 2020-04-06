package com.servyou.cloud.service;

import java.math.BigDecimal;

public interface AccountService {

    void deduction(Long userId, BigDecimal money);
}
