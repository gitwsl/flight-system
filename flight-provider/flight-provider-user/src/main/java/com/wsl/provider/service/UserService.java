package com.wsl.provider.service;

import com.wsl.provider.model.vo.ExerciseVO;
import com.wsl.provider.model.vo.UserVO;

import java.util.List;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
public interface UserService {
	/***
	 * select by id
	 * @param id
	 * @return UserVO
	 */
	UserVO selectById(Long id);

	List<ExerciseVO> selectExerciseListByUserId(Long id);
}
