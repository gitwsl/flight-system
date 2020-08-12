package com.wsl.flight.provider.score;

import com.wsl.flight.common.config.SwaggerConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.wsl.flight.provider.score.provider.dao")
@Import(SwaggerConfiguration.class)
@EnableScheduling
public class FlightProviderScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightProviderScoreApplication.class, args);
    }

}
