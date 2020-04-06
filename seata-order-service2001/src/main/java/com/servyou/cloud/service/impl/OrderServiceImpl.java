package com.servyou.cloud.service.impl;

import com.servyou.cloud.dao.OrderDao;
import com.servyou.cloud.domain.Order;
import com.servyou.cloud.service.AccountService;
import com.servyou.cloud.service.OrderService;
import com.servyou.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("---------创建订单--------");
        orderDao.create(order);

        log.info("---------订单服务调库存服务减库存数-------------");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("--------------订单服务调账户服务扣款--------------");
        accountService.deduction(order.getUserId(),order.getMoney());

        log.info("--------------修改订单状态:已完结 ------------------");
        orderDao.update(order.getUserId(),0);

        log.info("---------创建订单完成--------");
    }
}
