package com.wsl.provider.web.frontend;

import com.alibaba.fastjson.JSON;
import com.wsl.service.UserFeignApi;
import com.wsl.flight.common.response.ResponseObject;
import com.wsl.provider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@RestController
@RequestMapping("/flight/provider/user/")
@Slf4j
@Api(value = "flight - provider - user")
public class UserController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "根据ID获取用户信息")
    public String selectById(@ApiParam(name = "userInfo", value = "查询用户信息") @PathVariable("id") Long id) {
        log.info("id is {}, userVO = {}", id, userService.selectById(id));
//        return JSON.toJSONString(userService.selectById(id));
        return JSON.toJSONString(ResponseObject.ofSuccess( userService.selectById(id)));
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "test-根据ID获取用户信息")
    public String test(@ApiParam(name = "userInfo", value = "test-查询用户信息") @RequestParam("id") Long id) {
        log.info("id is {}, userVO = {}", id, userService.selectById(id));
        return JSON.toJSONString(userService.selectById(id));
    }

    @RequestMapping(value = "selectExerciseListByUserId", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "test-根据ID获取用户信息")
    public String selectExerciseListByUserId(@ApiParam(name = "selectExerciseListByUserId", value = "test-查询用户习题") @RequestParam("id") Long id) {
        return JSON.toJSONString(userService.selectExerciseListByUserId(id));
    }
}