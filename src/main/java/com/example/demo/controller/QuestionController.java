package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Question;
import com.example.demo.entity.User;
import com.example.demo.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	public HttpSession session;

	@RequestMapping(value = "/question/", method = RequestMethod.GET)
	public String login(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			String errorMessage = "不正なアクセスです";
			User user = new User();
			model.addAttribute("user",user);
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		
//		解答削除処理
		List<Question> allQuestion = questionService.allQuestion();
		Integer answerResult = null;
		Integer judge = null;
		for(int i = 0; i < allQuestion.size(); i++) {
			Question questionData = allQuestion.get(i);
			questionData.setAnswerResult(answerResult);
			questionData.setJudge(judge);
			questionService.addAnswer(questionData);
		}
		
		Question firstQuestion = questionService.selectQuestion(1);
		List<Question> allQuestionData = questionService.allQuestion();
		Question question = new Question();
		
		model.addAttribute("allQuestionData",allQuestionData);
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("question",question);
		model.addAttribute("nowQuestion",firstQuestion);
		return "question";
	}
	
	@RequestMapping(value = "/addQuestion/", method = RequestMethod.POST)
	public String addQuestion(Model model,Question question) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		Question questionForm = new Question();
		
		int judge = 0;
		if(question.getAnswerResult() == question.getAnswer()) {
			judge= 1;
		}
		question.setJudge(judge);
		questionService.addAnswer(question);
		
		Question nowQuestion = questionService.selectQuestion(question.getId());
		List<Question> allQuestionData = questionService.allQuestion();
		
		model.addAttribute("allQuestionData",allQuestionData);
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("question",questionForm);
		model.addAttribute("nowQuestion",nowQuestion);
		return "question";
	}
	
	@RequestMapping(value = "/nextQuestion/", method = RequestMethod.POST)
	public String nextQuestion(Model model,Question question) {

		User loginUser = (User)session.getAttribute("loginUser");
		Question questionForm = new Question();
		int id = question.getId();
		if(id >= 10) {
			Question nowQuestion =questionService.selectQuestion(10);
			List<Question> allQuestionData = questionService.allQuestion();

			model.addAttribute("allQuestionData",allQuestionData);
			model.addAttribute("loginUser",loginUser);
			model.addAttribute("question",questionForm);
			model.addAttribute("nowQuestion",nowQuestion);
			return "question";
		}
		id = id + 1;
		Question nowQuestion =questionService.selectQuestion(id);
		List<Question> allQuestionData = questionService.allQuestion();

		model.addAttribute("allQuestionData",allQuestionData);
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("question",questionForm);
		model.addAttribute("nowQuestion",nowQuestion);
		return "question";
	}

	@RequestMapping(value = "/returnQuestion/", method = RequestMethod.POST)
	public String returnQuestion(Model model,Question question) {

		User loginUser = (User)session.getAttribute("loginUser");
		Question questionForm = new Question();
		
		int id = question.getId();
		if(id <= 1) {
			Question nowQuestion =questionService.selectQuestion(1);
			List<Question> allQuestionData = questionService.allQuestion();

			model.addAttribute("allQuestionData",allQuestionData);
			model.addAttribute("loginUser",loginUser);
			model.addAttribute("question",questionForm);
			model.addAttribute("nowQuestion",nowQuestion);
			return "question";
		}
		id = id + -1;
		Question nowQuestion =questionService.selectQuestion(id);
		List<Question> allQuestionData = questionService.allQuestion();

		model.addAttribute("allQuestionData",allQuestionData);
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("question",questionForm);
		model.addAttribute("nowQuestion",nowQuestion);
		return "question";

	}
	
	@RequestMapping(value = "/pagenation/", method = RequestMethod.POST)
	public String pagenation(Model model,Question question) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		Question questionForm = new Question();
		Question nowQuestion =questionService.selectQuestion(question.getId());
		List<Question> allQuestionData = questionService.allQuestion();
		
		model.addAttribute("allQuestionData",allQuestionData);
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("question",questionForm);
		model.addAttribute("nowQuestion",nowQuestion);
		return "question";
	}
}
