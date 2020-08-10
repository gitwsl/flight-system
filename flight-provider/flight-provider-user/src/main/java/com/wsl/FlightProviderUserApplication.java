package com.wsl;

import com.wsl.flight.common.config.SwaggerConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = "com.wsl.provider.dao")
@Import(SwaggerConfiguration.class)
public class FlightProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightProviderUserApplication.class, args);
    }

}
