package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Score;
import com.example.demo.repository.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	public void insertScore(Score score) {
		scoreRepository.insertScore(score);
	}
	
	public List<Score> userScore (Score score){
		return scoreRepository.userScore(score);
	}
	
	public List<Score> allScore (){
		return scoreRepository.allScore();
	}

}
