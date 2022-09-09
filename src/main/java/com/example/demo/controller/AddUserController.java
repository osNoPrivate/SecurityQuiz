package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(value = "/addUser/", method = RequestMethod.GET)
	public String addUser(Model model) {
		
		UserForm userForm = new UserForm();
		model.addAttribute("userForm",userForm);

		return "addUser";
	}
	
	@RequestMapping(value = "/addUser/insert/", method = RequestMethod.POST)
	public String addUserInsert(Model model,@Validated @ModelAttribute UserForm userForm, BindingResult result) {
		
		List<String> errorList = new ArrayList<String>();
		
		if (result.hasErrors()) {
			if (!isValid(userForm,errorList)) {
				model.addAttribute("validationError", errorList);
				return "addUser";
			}
			return "addUser";
			
		}else {
			if (!isValid(userForm,errorList)) {
				model.addAttribute("validationError", errorList);
				return "addUser";
			}
			
			try {
				userService.insertUser(userForm);
			}catch (DuplicateKeyException e){
//				業務処理ユーザー重複
				errorList.add("ユーザーが重複しています。");
				model.addAttribute("validationError", errorList);
				return "addUser";
			}
		}
		
		return "redirect:/";
	}
	
	private boolean isValid(UserForm userForm,List<String> errorList) {
		String password = userForm.getPassword();
		String checkPassword = userForm.getCheckPassword();
		
		if (!password.equals(checkPassword)) {
			errorList.add("パスワードが一致しません。");
		}
		if (errorList.size() != 0) {
			return false;
		}
		return true;
	}
}
