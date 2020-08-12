package com.wsl.service;

import com.wsl.service.hystrix.ScoreHystrix;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "flight-provider-score", fallback = ScoreHystrix.class)
public interface ScoreFeignApi {

    @RequestMapping(value = "/flight/provider/score/rpc/find", method = RequestMethod.GET)
    String find();


    @RequestMapping(value = "/flight/provider/score/rpc/{id}", method = RequestMethod.GET)
    String select(@ApiParam(name = "scoreInfo", value = "查询成绩信息") @PathVariable("id") Long id);

}
