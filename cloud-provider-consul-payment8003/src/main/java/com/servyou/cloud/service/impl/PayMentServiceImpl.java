package com.servyou.cloud.service.impl;

import com.servyou.cloud.dao.ConsulPayMentDao;
import com.servyou.cloud.pojo.Payment;
import com.servyou.cloud.service.PayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayMentServiceImpl implements PayMentService {

    @Resource
    private ConsulPayMentDao paymentDao;

    /**
     * 新增
     *
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
