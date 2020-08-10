package com.wsl.provider.service.impl;

import com.wsl.flight.provider.score.api.service.ScoreFeignApi;
import com.wsl.provider.dao.UserDAO;
import com.wsl.provider.model.vo.UserVO;
import com.wsl.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
        log.info("****************" + scoreFeignApi.find() + "****************");
        log.info("****************" + scoreFeignApi.select(1L) + "****************");
        return userDAO.selectById(id);

    }
}
