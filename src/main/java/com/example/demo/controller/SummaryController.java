package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/summary/", method = RequestMethod.GET)
	public String summary(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		User user = new User();
		
		if(loginUser == null || loginUser.getSummary() != 1) {
			String errorMessage = "不正なアクセスです";
			model.addAttribute("user",user);
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		List<User> allUserData = userService.allUser();
		List<Score> allScoreData = scoreService.allScore();
		
		List<SummaryUserData> userDataList = new ArrayList<SummaryUserData>();
		
		for(int i= 0 ;allUserData.size()>i;i++ ) {
			User userData = allUserData.get(i);
			SummaryUserData summaryUserData = new SummaryUserData();
			summaryUserData.setId(userData.getId());
			summaryUserData.setAccount(userData.getAccount());
			summaryUserData.setName(userData.getName());
			summaryUserData.setSummary(userData.getSummary());
			summaryUserData.setCreatedDate(userData.getCreatedDate());
			summaryUserData.setPassword(userData.getPassword());
			Integer result = 0;
			
			for(int j= 0 ;allScoreData.size()>j;j++ ) {
				Score scoreData = allScoreData.get(j);
				if(userData.getId()==scoreData.getUserId()) {
					if(scoreData.getScore()==100) {
						result= 1;
					}
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
