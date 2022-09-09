package com.example.demo.repository.mapper;

import java.util.List;

import com.example.demo.entity.Question;

public interface QuestionMapper {
	
	List<Question> allQuestion();
	
	Question selectQuestion(int id);

	void addAnswer(Question nowQuestion);
	
	List<Question> countAnswer();
}
