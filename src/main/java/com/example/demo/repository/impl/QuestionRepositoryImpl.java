package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.mapper.QuestionMapper;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository{

	private final QuestionMapper questionMapper;
	
	public QuestionRepositoryImpl(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}
	
	@Override
	public List<Question> allQuestion(){
		return this.questionMapper.allQuestion();
	}
	
	@Override
	public Question selectQuestion(int id) {
		return this.questionMapper.selectQuestion(id);
	}
	
	@Override
	public void addAnswer(Question nowQuestion) {
		this.questionMapper.addAnswer(nowQuestion);
	}
	
	@Override
	public List<Question>countAnswer(){
		return this.questionMapper.countAnswer();
	}
}
