package com.wsl.provider.service.impl;

import com.wsl.provider.model.vo.ExerciseVO;
import com.wsl.service.ExerciseFeignApi;
import com.wsl.service.ScoreFeignApi;
import com.wsl.provider.dao.UserDAO;
import com.wsl.provider.model.vo.UserVO;
import com.wsl.provider.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private ExerciseFeignApi exerciseFeignApi;

    @Override
    public UserVO selectById(Long id) {
//		log.info("查询用户信息. id ={}", id);
        log.info("****************" + scoreFeignApi.find() + "****************");
        log.info("****************" + scoreFeignApi.select(1L) + "****************");
        return userDAO.selectById(id);
    }

    @Override
    public List<ExerciseVO> selectExerciseListByUserId(Long id) {
        log.info("****************" + exerciseFeignApi.findByUserId(id) + "****************");
        return new ArrayList<>();
    }


}
