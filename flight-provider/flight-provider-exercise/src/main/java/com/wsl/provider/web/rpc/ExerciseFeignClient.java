package com.wsl.provider.web.rpc;

import com.wsl.service.ExerciseFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@RestController
public class ExerciseFeignClient implements ExerciseFeignApi {

    @Override
    public String findByUserId(Long userId) {
        log.info("ExerciseFeignClient.select  获取{}用户创建的习题", userId);
        return "ExerciseFeignClient.select  获取" + userId + "用户创建的习题";
    }
}
