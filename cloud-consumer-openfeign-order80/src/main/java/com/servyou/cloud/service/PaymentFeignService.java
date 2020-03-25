package com.servyou.cloud.service;

import com.servyou.cloud.fallback.PaymetFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * openfeign 客户端调用payment微服务接口
 *
 */
@Component
@FeignClient(value = "consul-provider-server",fallbackFactory = PaymetFallbackFactory.class) //指定调用的服务,fallback 还可以创建类实现该接口
public interface PaymentFeignService {

    /**
     * 这里表示调用consul-provider-server中的payment/consul接口
     * 使用SpringMVC 的注解来绑定具体该服务提供的 REST 接口
     * @return
     */
    @RequestMapping(value = "payment/consul")
    String paymentConsul();

    @RequestMapping(value = "payment/circuit/consul/{id}")
    String paymentCircuitConsul(@PathVariable("id") Integer id);
}
