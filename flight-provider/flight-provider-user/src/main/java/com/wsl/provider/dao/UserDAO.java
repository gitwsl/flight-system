package com.wsl.provider.dao;

import com.wsl.provider.model.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@Repository
public interface UserDAO {

	/***
	 *
	 * @param id
	 * @return
	 */
	UserVO selectById(Long id);

}