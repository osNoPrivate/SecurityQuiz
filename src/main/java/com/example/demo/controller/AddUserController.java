package com.example.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

@Controller
public class AddUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public HttpSession session;
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/addUser/", method = RequestMethod.GET)
	public String addUser(Model model) {
		
		UserForm userForm = new UserForm();
		model.addAttribute("userForm",userForm);
		return "addUser";
	}
	
	@RequestMapping(value = "/addUser/insert/", method = RequestMethod.POST)
	public String addUserInsert(Model model,@Validated @ModelAttribute UserForm userForm, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addUser";
		}else {
			try {
				userService.insertUser(userForm);
			}catch (DuplicateKeyException e){
//				業務処理ユーザー重複
				model.addAttribute("errorMessage",messageSource.getMessage("e.duplicateKeyException.message", new String[]{}, Locale.JAPAN));
				return "addUser";
			}
		}
		return "redirect:/";
	}
}
