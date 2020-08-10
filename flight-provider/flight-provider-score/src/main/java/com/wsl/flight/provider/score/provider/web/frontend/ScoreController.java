package com.wsl.flight.provider.score.provider.web.frontend;

import com.alibaba.fastjson.JSON;
import com.wsl.flight.provider.score.provider.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@RestController
@RequestMapping("/flight/provider/score/")
@Slf4j
@Api(value = "flight - provider - score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据ID获取成绩信息")
    public String selectById(@ApiParam(name = "scoreInfo", value = "查询成绩信息") @PathVariable("id") Long id) {
        log.info("ScoreController id is {}, scoreVO = {}", id, scoreService.selectById(id));
        return JSON.toJSONString(scoreService.selectById(id));
    }

}