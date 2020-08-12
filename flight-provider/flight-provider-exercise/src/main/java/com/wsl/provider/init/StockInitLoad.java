package com.wsl.provider.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author lin.wang
 * @date 2020/7/11
 */
@Component
@Order(1)
@Slf4j
public class StockInitLoad implements CommandLineRunner {

    @Override
    public void run(String... args) {
       log.info("<=========================== 项目启动-加载所有习题 =====================>");
    }
}
