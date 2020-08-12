package com.wsl.service;


import com.wsl.service.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "flight-provider-user", fallback = UserHystrix.class)
public interface UserFeignApi {
    @RequestMapping(value = "/flight/provider/user/rpc/find", method = RequestMethod.GET)
    String find();

}
