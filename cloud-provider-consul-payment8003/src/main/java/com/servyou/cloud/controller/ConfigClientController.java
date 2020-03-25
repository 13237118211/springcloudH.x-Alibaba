package com.servyou.cloud.controller;

import com.servyou.cloud.pojo.CommonResult;
import com.servyou.cloud.pojo.Payment;
import com.servyou.cloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 主要测试将数据源等一些公共配置抽取到中心配置  利用bootstrap.yml读取即可
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String username;

    @Resource
    private PayMentService payMentService;

    @GetMapping("/getConfiginfo")
    public String getConfiginfo(){
        return username;
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = payMentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功, ", payment);
        }
        return new CommonResult(444, "没有对应记录,查询ID:" + id, null);
    }
}
