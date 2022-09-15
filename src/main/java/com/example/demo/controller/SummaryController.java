package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Score;
import com.example.demo.entity.User;
import com.example.demo.form.SummaryUserData;
import com.example.demo.service.ScoreService;
import com.example.demo.service.UserService;

@Controller
public class SummaryController {
	
	@Autowired
	public HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/summary/", method = RequestMethod.GET)
	public String summary(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		User user = new User();
		
		if(loginUser == null || loginUser.getSummary() != 1) {
			model.addAttribute("user",user);
			model.addAttribute("errorMessage",messageSource.getMessage("loginCheck.Message", new String[]{}, Locale.JAPAN));
			return "login";
		}
		
		List<User> allUserData = userService.allUser();
		List<Score> allScoreData = scoreService.allScore();
		List<SummaryUserData> userDataList = new ArrayList<SummaryUserData>();
		
		for(User userData:allUserData) {
			SummaryUserData summaryUserData = new SummaryUserData();
			summaryUserData.setId(userData.getId());
			summaryUserData.setAccount(userData.getAccount());
			summaryUserData.setName(userData.getName());
			summaryUserData.setSummary(userData.getSummary());
			summaryUserData.setCreatedDate(userData.getCreatedDate());
			summaryUserData.setPassword(userData.getPassword());
			Integer result = 0;
			for(Score scoreData:allScoreData) {
				if(userData.getId()==scoreData.getUserId() && scoreData.getScore()==100) {
					result= 1;
				}
			}
			summaryUserData.setResult(result);
			userDataList.add(summaryUserData);
		}
		
		model.addAttribute("userDataList", userDataList);
		model.addAttribute("user", user);
		return "summary";
	}
	
	@RequestMapping(value = "/deleteUser/", method = RequestMethod.POST)
	public String deleteUser(Model model,@ModelAttribute User user) {
		userService.deleteUser(user);
		return "redirect:/summary/";
	}
}
