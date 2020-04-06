package com.servyou.cloud.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountDao {

    void deduction(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
