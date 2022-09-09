package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {
		
		User user = new User();
		
		model.addAttribute("user",user);
		return "login";
	}
	
	@RequestMapping(value = "/login/check/", method = RequestMethod.POST)
	public String checkUser(Model model,User user) {
		
		User checkUser = userService.checkUser(user);
		
		if(checkUser == null) {
			List<String> errorList = new ArrayList<String>();
			errorList.add("ログインに失敗しました。");
			User reUser = new User();

			model.addAttribute("validationError", errorList);
			model.addAttribute("user",reUser);
	        return "login";
		}

		session.setAttribute("loginUser", checkUser);
		return "redirect:/home/";
	}

}
