package com.servyou.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.servyou.cloud.dao")
public class ProviderConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConsulApplication.class, args);
    }
}
