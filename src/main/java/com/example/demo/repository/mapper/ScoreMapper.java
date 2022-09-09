package com.example.demo.repository.mapper;

import java.util.List;

import com.example.demo.entity.Score;

public interface ScoreMapper {
	
	void insertScore(Score score);
	
	List<Score> userScore(Score score);
	
	List<Score> allScore();

}
