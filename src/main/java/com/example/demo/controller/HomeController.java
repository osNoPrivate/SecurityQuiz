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

import com.example.demo.entity.Score;
import com.example.demo.entity.User;
import com.example.demo.service.ScoreService;

@Controller
public class HomeController {

	@Autowired
	public HttpSession session;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/home/", method = RequestMethod.GET)
	public String home(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			User user = new User();
			model.addAttribute("user",user);
			model.addAttribute("errorMessage",messageSource.getMessage("loginCheck.Message", new String[]{}, Locale.JAPAN));
			return "login";
		}
		
		Score score = new Score();
		score.setUserId(loginUser.getId());
		List<Score> userScore = scoreService.userScore(score);
		
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("userScore",userScore);
		return "home";
	}
}
