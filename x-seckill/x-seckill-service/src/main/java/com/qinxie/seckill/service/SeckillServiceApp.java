package com.qinxie.seckill.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.qinxie.seckill.dao.mapper"})
public class SeckillServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(SeckillServiceApp.class,args);
    }
}
