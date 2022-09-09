package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> allQuestion(){
		return questionRepository.allQuestion();
	}
	
	public Question selectQuestion(int id) {
		return questionRepository.selectQuestion(id);
	}
	
	public void addAnswer(Question nowQuestion) {
		questionRepository.addAnswer(nowQuestion);
	}
	
	public int countAnswer() {
		List<Question> questionData = questionRepository.countAnswer();
		int score = questionData.size() * 10;
		return score;
	}

}
