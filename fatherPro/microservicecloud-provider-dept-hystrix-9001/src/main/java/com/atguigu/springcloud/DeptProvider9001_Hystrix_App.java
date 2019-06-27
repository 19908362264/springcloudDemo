package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class DeptProvider9001_Hystrix_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider9001_Hystrix_App.class, args);
    }
}
