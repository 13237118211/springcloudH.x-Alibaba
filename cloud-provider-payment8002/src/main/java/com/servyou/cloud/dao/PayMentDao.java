package com.servyou.cloud.dao;

import com.servyou.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PayMentDao {
    /**
     * 新增
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
