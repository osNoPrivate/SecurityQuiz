package com.example.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {
		
		User user = new User();
		
		model.addAttribute("user",user);
		return "login";
	}
	
		/**
		 * ログイン機能
		 * 
		 * @param model
		 * @param user login確認用フォーム
		 * @return home画面への遷移
		 */
	
	@RequestMapping(value = "/login/check/", method = RequestMethod.POST)
	public String checkUser(Model model,User user) {
		
		User checkUser = userService.checkUser(user);
		
		if(checkUser == null) {
			model.addAttribute("errorMessage",messageSource.getMessage("LoginFailed.Message", new String[]{}, Locale.JAPAN));
			model.addAttribute("user",new User());
	        return "login";
		}

		session.setAttribute("loginUser", checkUser);
		return "redirect:/home/";
	}

}
