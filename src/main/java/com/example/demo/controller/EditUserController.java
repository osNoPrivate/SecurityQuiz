package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/editUser/", method = RequestMethod.GET)
	public String editUser(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		EditUserForm editUserForm = new EditUserForm();
		
		model.addAttribute("loginUser",loginUser);
		model.addAttribute("editUserForm",editUserForm);
		return "editUser";
	}
	
	@RequestMapping(value = "/editUser/update/", method = RequestMethod.POST)
	public String addUserUpdate(Model model,@Validated @ModelAttribute EditUserForm editUserForm, BindingResult result) {
		User loginUser = (User)session.getAttribute("loginUser");
		List<String> errorList = new ArrayList<String>();
		if (result.hasErrors()) {
			if (!isValid(editUserForm,errorList)) {
				model.addAttribute("validationError", errorList);
				return "editUser";
			}
			return "editUser";
		}else {
			if (!isValid(editUserForm,errorList)) {
				model.addAttribute("validationError", errorList);
				return "editUser";
			}
		
			if(!StringUtils.isBlank(editUserForm.getPassword())) {
				try {
					userService.updateEncUser(editUserForm);
				}catch (DuplicateKeyException e){
		//			業務処理ユーザー重複
					errorList.add("ユーザーが重複しています。");
					model.addAttribute("validationError", errorList);
					return "editUser";
				}
			}
			
			if(StringUtils.isBlank(editUserForm.getPassword())) {
				try {
					User user = new User();
					user.setId(loginUser.getId());
					User userData = userService.selectUser(user);
					editUserForm.setPassword(userData.getPassword());
					userService.updateUser(editUserForm);
				}catch (DuplicateKeyException e){
		//			業務処理ユーザー重複
					errorList.add("ユーザーが重複しています。");
					model.addAttribute("validationError", errorList);
					return "editUser";
				}
			}
		}
		
		loginUser = userService.selectUser(loginUser);
		session.setAttribute("loginUser", loginUser);
		
		return "redirect:/home/";
	}
	
	private boolean isValid(EditUserForm editUserForm,List<String> errorList) {
		String password = editUserForm.getPassword();
		String checkPassword = editUserForm.getCheckPassword();
		
		if ((!StringUtils.isBlank(password)) && (!password.matches("[-_@+*;:#$%&0-9a-zA-Z]+")))  {
			errorList.add("パスワードは半角英数記号のみで入力してください。");
		}
		if ((!StringUtils.isBlank(checkPassword)) && (!checkPassword.matches("[-_@+*;:#$%&0-9a-zA-Z]+")))  {
			errorList.add("確認用パスワードは半角英数記号のみで入力してください。");
		}

		if (!password.equals(checkPassword)) {
			errorList.add("パスワードが一致しません。");
		}

		if (errorList.size() != 0) {
			return false;
		}
		return true;
	}
	

}
