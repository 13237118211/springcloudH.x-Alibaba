package com.servyou.cloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义轮询算法
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 得到每次访问是第几次 CAS+自选锁
     * @return
     */
    private final int getAndIncrement() {
        for (; ; ) {
            int current = atomicInteger.get();
            int next = current >= 2147483647 ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)){
                System.out.println(Thread.currentThread().getName()+": "+next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }

    /**
     * 测试多线程下CAS
     */
    @Override
    public void run() {
        getAndIncrement();
    }
}
