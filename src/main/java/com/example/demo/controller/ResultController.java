package com.example.demo.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/result/", method = RequestMethod.POST)
	public String result(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		List<Question> allQuestion = questionService.allQuestion();
		
//		未回答の項目がある際の処理
		
		for(Question questionData : allQuestion) {
			if(questionData.getAnswerResult() == null) {
				Question nowQuestion = questionService.selectQuestion(questionData.getId());
				Question question = new Question();
				List<Question> allQuestionData = questionService.allQuestion();
				model.addAttribute("allQuestionData",allQuestionData);
				model.addAttribute("loginUser",loginUser);
				model.addAttribute("errorMessage",messageSource.getMessage("unanswered,Message", new String[]{}, Locale.JAPAN));
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
		model.addAttribute("allQuestion",allQuestion);
		return "result";
	}

}
