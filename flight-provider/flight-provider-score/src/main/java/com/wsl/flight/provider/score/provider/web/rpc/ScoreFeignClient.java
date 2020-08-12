package com.wsl.flight.provider.score.provider.web.rpc;

import com.wsl.service.ScoreFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@RestController
public class ScoreFeignClient implements ScoreFeignApi {
    @Override
    public String find() {
        log.info("ScoreFeignClient.find");
        return "ScoreFeignClient.find";
    }

    @Override
    public String select(Long id) {
        log.info("ScoreFeignClient.select");
        return "ScoreFeignClient.select";
    }
}
