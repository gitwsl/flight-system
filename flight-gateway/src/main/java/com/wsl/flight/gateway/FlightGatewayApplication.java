package com.wsl.flight.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 * TODO 网关现在无法启动，不知道原因
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class FlightGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightGatewayApplication.class, args);
    }

}
