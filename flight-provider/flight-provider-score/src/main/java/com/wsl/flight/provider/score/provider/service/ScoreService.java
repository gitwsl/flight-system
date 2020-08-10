package com.wsl.flight.provider.score.provider.service;

import com.wsl.flight.provider.score.provider.model.vo.ScoreVO;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
public interface ScoreService {
	/***
	 * select by id
	 * @param id
	 * @return ScoreVO
	 */
	ScoreVO selectById(Long id);
}
