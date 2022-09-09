package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	@Autowired
	public HttpSession session;
	
	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public String addUser() {
		session.invalidate();
		return "redirect:/";
	}
}
