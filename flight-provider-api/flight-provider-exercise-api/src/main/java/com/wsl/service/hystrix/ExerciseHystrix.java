package com.wsl.service.hystrix;

import com.wsl.service.ExerciseFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@Component
public class ExerciseHystrix implements ExerciseFeignApi {

    @Override
    public String findByUserId(Long userId) {
        return "ExerciseHystrix.findByUserId";
    }
}
