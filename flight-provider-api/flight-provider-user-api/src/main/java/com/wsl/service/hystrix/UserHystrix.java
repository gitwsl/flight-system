package com.wsl.service.hystrix;

import com.wsl.service.UserFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@Component
public class UserHystrix implements UserFeignApi {
    @Override
    public String find() {
        return null;
    }
}
