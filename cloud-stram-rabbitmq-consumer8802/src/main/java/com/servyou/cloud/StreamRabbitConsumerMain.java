package com.servyou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StreamRabbitConsumerMain {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumerMain.class, args);
    }

}
