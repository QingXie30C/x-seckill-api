package com.qinxie.seckill.auth.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther qinxie30c
 * @date 2021/2/10 10:53 上午
 * @desc:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthBaseApp.class,args);
    }
}
