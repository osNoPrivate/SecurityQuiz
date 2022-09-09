package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Question;
import com.example.demo.entity.Score;
import com.example.demo.entity.User;
import com.example.demo.service.QuestionService;
import com.example.demo.service.ScoreService;

@Controller
public class ResultController {
	
	@Autowired
	public HttpSession session;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value = "/result/", method = RequestMethod.POST)
	public String result(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		List<Question> allQuestion = questionService.allQuestion();
		
//		未回答の項目がある際の処理
		for(int i = 0; i < allQuestion.size(); i++) {
			Question questionData = allQuestion.get(i);
			if(questionData.getAnswerResult() == null) {
				Question nowQuestion = questionService.selectQuestion(questionData.getId());
				Question question = new Question();
				List<String> errorList = new ArrayList<String>();
				errorList.add("未解答の項目があります。");
				
				model.addAttribute("loginUser",loginUser);
				model.addAttribute("validationError",errorList);
				model.addAttribute("question",question);
				model.addAttribute("nowQuestion",nowQuestion);
				return "question";
			}
		}
		
//		点数の集計とセット
		int score = questionService.countAnswer();
		
		Score userScore = new Score();
		userScore.setScore(score);
		userScore.setUserId(loginUser.getId());
		scoreService.insertScore(userScore);
		
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("score",score);
		model.addAttribute("question1",allQuestion.get(0));
		model.addAttribute("question2",allQuestion.get(1));
		model.addAttribute("question3",allQuestion.get(2));
		model.addAttribute("question4",allQuestion.get(3));
		model.addAttribute("question5",allQuestion.get(4));
		model.addAttribute("question6",allQuestion.get(5));
		model.addAttribute("question7",allQuestion.get(6));
		model.addAttribute("question8",allQuestion.get(7));
		model.addAttribute("question9",allQuestion.get(8));
		model.addAttribute("question10",allQuestion.get(9));
		return "result";
	}

}
