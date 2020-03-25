package com.servyou.cloud.service;

import com.servyou.cloud.pojo.Payment;

public interface PayMentService {
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
    Payment getPaymentById(Long id);
}
