package com.wsl.flight.provider.score.provider.service.impl;

import com.wsl.flight.provider.score.provider.dao.ScoreDAO;
import com.wsl.flight.provider.score.provider.model.vo.ScoreVO;
import com.wsl.flight.provider.score.provider.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreDAO scoreDAO;

	@Override
	public ScoreVO selectById(Long id) {
//		log.info("查询用户信息. id ={}", id);

		return scoreDAO.selectOne(id);

	}
}
