package com.servyou.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableDiscoveryClient @EnableEurekaClient都是服务发现注解
 * 但@EnableEurekaClient只适用于eureka @EnableDiscoveryClient适用于其他注册中心
 * 这两个注解在springboot E版本之后都可以省了 只需要引入依赖yml配置即可
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.servyou.cloud.dao")
public class PayMentAppliction8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentAppliction8001.class, args);
    }
}
