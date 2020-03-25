package com.servyou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="CLOUD-PROVIDER-SERVICE", configuration = MySelfRule.class) //替换默认负载均衡机制-轮询
public class OrderApplication8000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8000.class, args);
    }

}
