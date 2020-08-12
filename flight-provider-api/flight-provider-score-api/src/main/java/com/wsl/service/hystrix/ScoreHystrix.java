package com.wsl.service.hystrix;

import com.wsl.service.ScoreFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lin.wang
 * @date 2020/08/07
 */
@Slf4j
@Component
public class ScoreHystrix implements ScoreFeignApi {
    @Override
    public String find() {
        return "ScoreHystrix.find...";
    }

    @Override
    public String select(Long id) {
        return "ScoreHystrix.select...";
    }
}
