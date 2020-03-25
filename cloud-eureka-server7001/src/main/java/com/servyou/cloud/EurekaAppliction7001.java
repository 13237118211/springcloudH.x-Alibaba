package com.servyou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaAppliction7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaAppliction7001.class, args);
    }
}
