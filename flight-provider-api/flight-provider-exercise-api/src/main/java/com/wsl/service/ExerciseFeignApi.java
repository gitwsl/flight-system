package com.wsl.service;


import com.wsl.service.hystrix.ExerciseHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "flight-provider-exercise", fallback = ExerciseHystrix.class)
public interface ExerciseFeignApi {

    @RequestMapping(value = "/flight/provider/exercise/api/find", method = RequestMethod.GET)
    String findByUserId(@RequestParam("userId") Long userId);
}
