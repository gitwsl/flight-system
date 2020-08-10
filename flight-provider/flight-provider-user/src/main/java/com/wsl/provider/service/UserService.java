package com.wsl.provider.service;

import com.wsl.provider.model.vo.UserVO;

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
}
