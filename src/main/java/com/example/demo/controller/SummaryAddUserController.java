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

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.selectModel.SummaryModel;
import com.example.demo.service.UserService;

@Controller
public class SummaryAddUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	public HttpSession session;
	
	@RequestMapping(value = "/summaryAddUser/", method = RequestMethod.GET)
	public String summaryAddUser(Model model) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		User user = new User();
		if(loginUser == null || loginUser.getSummary() != 1) {
			String errorMessage = "不正なアクセスです";
			model.addAttribute("user",user);
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		UserForm userForm = new UserForm();
		List<SummaryModel> selectName = getStatus();
		
		model.addAttribute("userForm",userForm);
		model.addAttribute("selectName",selectName);
		return "summaryAddUser";
	}
	
	@RequestMapping(value = "/summaryAddUser/insert/", method = RequestMethod.POST)
	public String addUserInsert(Model model,@Validated @ModelAttribute UserForm userForm, BindingResult result) {
		
		List<String> errorList = new ArrayList<String>();
		List<SummaryModel> selectName = getStatus();
		if (result.hasErrors()) {
			model.addAttribute("selectName",selectName);
			
			if (!isValid(userForm,errorList)) {
				model.addAttribute("validationError", errorList);
				return "summaryAddUser";
			}
			return "summaryAddUser";
			
		}else {
			if (!isValid(userForm,errorList)) {
				model.addAttribute("selectName",selectName);
				model.addAttribute("validationError", errorList);
				return "summaryAddUser";
			}
			
			try {
				userService.insertUser(userForm);
			}catch (DuplicateKeyException e){
//				業務処理ユーザー重複
				errorList.add("ユーザーが重複しています。");
				model.addAttribute("selectName",selectName);
				model.addAttribute("validationError", errorList);
				return "summaryAddUser";
			}
		}
		
		return "redirect:/summaryAddUser/";
	}
	
	
	private List<SummaryModel>getStatus(){

		List<SummaryModel> list = new ArrayList<>();
		list.add(new SummaryModel(0,"選択"));
		list.add(new SummaryModel(1,"人事"));
		list.add(new SummaryModel(2,"インターン生"));
		return list;
		
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
