package com.servyou.cloud.controller;

import com.servyou.cloud.pojo.CommonResult;
import com.servyou.cloud.pojo.Payment;
import com.servyou.cloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PayMentController {

    @Resource
    private PayMentService payMentService;

    @Value("${server.port}")
    private String serverPort;
    /**
     * 查询
     * http://localhost:8001/payment/get/31
     *
     * @param id
     * @return
     */
    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = payMentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort: "+serverPort,payment);
        }
        return new CommonResult(444, "没有对应记录,查询ID:" + id, null);
    }

}
