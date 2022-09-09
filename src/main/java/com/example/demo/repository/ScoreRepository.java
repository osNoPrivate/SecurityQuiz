package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Score;
import com.example.demo.repository.mapper.ScoreMapper;

@Repository
public class ScoreRepository {

	@Autowired
	private ScoreMapper scoreMapper;
	
	public void insertScore(Score score) {
		scoreMapper.insertScore(score);
	}
	
	public List<Score> userScore(Score score){
		return scoreMapper.userScore(score);
	}
	
	public List<Score> allScore(){
		return scoreMapper.allScore();
	}
}
