package com.wsl.api;


import com.wsl.api.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "flight-provider-user", fallback = UserHystrix.class)
public interface UserFeignApi {


}
