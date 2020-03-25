package com.servyou.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer extends Runnable {

    ServiceInstance instance(List<ServiceInstance> instances);
}
