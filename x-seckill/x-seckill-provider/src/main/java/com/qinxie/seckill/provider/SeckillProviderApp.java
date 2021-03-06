package com.qinxie.seckill.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;


@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class SeckillProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(SeckillProviderApp.class,args);
    }
}
