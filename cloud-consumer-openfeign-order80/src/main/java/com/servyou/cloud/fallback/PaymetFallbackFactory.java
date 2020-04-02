package com.servyou.cloud.fallback;

import com.servyou.cloud.service.PaymentFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymetFallbackFactory implements FallbackFactory<PaymentFeignService> {
    @Override
    public PaymentFeignService create(Throwable throwable) {
        return new PaymentFeignService(){

            @Override
            public String paymentConsul() {
                return "hystrix fallbackfactory : "+throwable.getMessage();
            }

            @Override
            public String paymentCircuitConsul(Integer id) {
                return id + "不能为负数";
            }

            @Override
            public String zipkin() {
                return "调用服务端zipkin失败";
            }
        };
    }
}
