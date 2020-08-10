package com.wsl.flight.provider.score.provider.dao;

import com.wsl.flight.provider.score.provider.model.vo.ScoreVO;
import org.springframework.stereotype.Repository;

/**
 * @author lin.wang
 * @date 2020/07/30
 */
@Repository
public interface ScoreDAO {

	/***
	 *
	 * @param id
	 * @return
	 */
	ScoreVO selectOne(Long id);

}