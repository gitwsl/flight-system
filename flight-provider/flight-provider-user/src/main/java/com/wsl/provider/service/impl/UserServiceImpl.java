package com.wsl.provider.service.impl;

import com.wsl.flight.provider.score.api.service.ScoreFeignApi;
import com.wsl.provider.dao.UserDAO;
import com.wsl.provider.model.vo.UserVO;
import com.wsl.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Resource
    private ScoreFeignApi scoreFeignApi;

    @Override
    public UserVO selectById(Long id) {
//		log.info("查询用户信息. id ={}", id);
        final String s = scoreFeignApi.find();
        log.info("****************" + s + "****************");
        final String select = scoreFeignApi.select(1L);
        log.info("****************" + select + "****************");
        final UserVO userVO = new UserVO();
        userVO.setName(s  +"\n" + select);
        return userVO;

    }
}
