package com.servyou.cloud.controller;

import com.servyou.cloud.lb.LoadBalancer;
import com.servyou.cloud.lb.MyLB;
import com.servyou.cloud.pojo.CommonResult;
import com.servyou.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //通过eureka中服务名来，达到负载均衡调用集群效果
    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 测试使用自定义轮询算法
     */
    @GetMapping("/consumer/payment/lb/{id}")
    public CommonResult<Payment> testMyLB(@PathVariable Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if(instances.size()<=0 || instances == null){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/test")
    public void testThread(){
        Thread a = new Thread(loadBalancer, "a");
        Thread b = new Thread(loadBalancer, "b");
        Thread c = new Thread(loadBalancer, "c");
        a.start();
        b.start();
        c.start();
    }
}
