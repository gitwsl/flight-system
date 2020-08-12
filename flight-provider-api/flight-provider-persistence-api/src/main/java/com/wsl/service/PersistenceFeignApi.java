package com.wsl.service;


import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "flight-provider-persistence", fallback = PersistenceFeignApi.class)
public interface PersistenceFeignApi {


}
