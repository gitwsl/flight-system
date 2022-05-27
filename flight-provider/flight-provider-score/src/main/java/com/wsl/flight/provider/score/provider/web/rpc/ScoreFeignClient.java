package com.wsl.flight.provider.score.provider.web.rpc;

import com.wsl.flight.provider.score.api.service.ScoreFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@RestController
@RequestMapping("/flight/provider/score/rpc")
public class ScoreFeignClient implements ScoreFeignApi {


    /***
     * feign事根据url调用的，这里find能调通，select注释掉了”/{id}“所以找不到方法就调不通，从而select走断路器降级方法
     * 这也是为什么feign叫伪rpc的原因，内部其实是http调用
     * @return
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @Override
    public String find() {
        log.info("ScoreFeignClient.find");
        return "ScoreFeignClient.find";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public String select(Long id) {
        log.info("ScoreFeignClient.select");
        return "ScoreFeignClient.select";
    }
}
