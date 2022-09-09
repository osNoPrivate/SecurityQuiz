package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Question;
import com.example.demo.repository.mapper.QuestionMapper;

@Repository
public class QuestionRepository {

	@Autowired
	private QuestionMapper questionMapper;
	
	public List<Question> allQuestion(){
		return questionMapper.allQuestion();
	}
	
	public Question selectQuestion(int id) {
		return questionMapper.selectQuestion(id);
	}
	
	public void addAnswer(Question nowQuestion) {
		questionMapper.addAnswer(nowQuestion);
	}
	
	public List<Question>countAnswer(){
		return questionMapper.countAnswer();
	}
}
