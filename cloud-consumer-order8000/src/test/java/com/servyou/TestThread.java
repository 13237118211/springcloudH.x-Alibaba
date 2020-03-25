package com.servyou;

import com.servyou.cloud.OrderApplication8000;
import com.servyou.cloud.lb.LoadBalancer;
import com.servyou.cloud.lb.MyLB;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=OrderApplication8000.class)
public class TestThread {

    @Resource
    private LoadBalancer loadBalancer;

    @org.junit.Test
    public void test(){
        Thread a = new Thread(loadBalancer, "a");
        Thread b = new Thread(loadBalancer, "b");
        Thread c = new Thread(loadBalancer, "c");
        a.start();
        b.start();
        c.start();
    }
}
