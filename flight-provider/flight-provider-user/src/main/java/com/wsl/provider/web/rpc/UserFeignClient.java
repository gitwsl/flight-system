package com.wsl.provider.web.rpc;

import com.wsl.service.UserFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@RestController
public class UserFeignClient implements UserFeignApi {
    @Override
    public String find() {
        return null;
    }
}
