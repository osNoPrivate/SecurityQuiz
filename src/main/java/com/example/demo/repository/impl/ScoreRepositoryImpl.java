package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Score;
import com.example.demo.repository.ScoreRepository;
import com.example.demo.repository.mapper.ScoreMapper;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

	private final ScoreMapper scoreMapper;
	
	public ScoreRepositoryImpl(ScoreMapper scoreMapper) {
			this.scoreMapper = scoreMapper;
	}
	
	@Override
	public List<Score> allScore(){
		return this.scoreMapper.allScore();
	}
	
	@Override
	public List<Score> userScore(Score score){
		return this.scoreMapper.userScore(score);
	}
	
	@Override
	public void insertScore(Score score) {
		this.scoreMapper.insertScore(score);
	}
	
}
