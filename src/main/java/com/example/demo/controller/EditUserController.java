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

import com.example.demo.entity.User;
import com.example.demo.form.EditUserForm;
import com.example.demo.service.UserService;

@Controller
public class EditUserController {
	
	@Autowired
	public HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/editUser/", method = RequestMethod.GET)
	public String editUser(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser == null) {
			User user = new User();
			model.addAttribute("user",user);
			model.addAttribute("errorMessage",messageSource.getMessage("loginCheck.Message", new String[]{}, Locale.JAPAN));
			return "login";
		}
		EditUserForm editUserForm = new EditUserForm();
		
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("editUserForm",editUserForm);
		return "editUser";
	}
	
	@RequestMapping(value = "/editUser/update/", method = RequestMethod.POST)
	public String addUserUpdate(Model model,@Validated @ModelAttribute EditUserForm editUserForm, BindingResult result) {
		User loginUser = (User)session.getAttribute("loginUser");
		if (result.hasErrors()) {
			return "editUser";
		}else {
			try {
				userService.allApdateUser(editUserForm);
			}catch (DuplicateKeyException e){
//				業務処理ユーザー重複
				model.addAttribute("errorMessage",messageSource.getMessage("e.duplicateKeyException.message", new String[]{}, Locale.JAPAN));
				return "editUser";
			}
		}
		
		loginUser = userService.selectUser(loginUser);
		session.setAttribute("loginUser", loginUser);
		
		return "redirect:/home/";
	}

}
