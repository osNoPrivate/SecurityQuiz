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
import com.example.demo.form.SummaryEditUserForm;
import com.example.demo.form.SummaryUserData;
import com.example.demo.selectModel.SummaryModel;
import com.example.demo.service.UserService;

@Controller
public class SummaryEditUserController {

	@Autowired
	public HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/summaryEditUser/", method = RequestMethod.POST)
	public String summaryEditUser(Model model,@ModelAttribute SummaryUserData userData) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		User newUser = new User();
		if(loginUser == null || loginUser.getSummary() != 1) {
			String errorMessage = "不正なアクセスです";
			model.addAttribute("user",newUser);
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		if(loginUser.getId() == userData.getId()) {
			String errorMessage = "不正なアクセスです";
			model.addAttribute("user",newUser);
			model.addAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		SummaryEditUserForm summaryEditUserForm = new SummaryEditUserForm();
		summaryEditUserForm.setId(userData.getId());
		summaryEditUserForm.setAccount(userData.getAccount());
		summaryEditUserForm.setName(userData.getName());
		summaryEditUserForm.setPassword(userData.getPassword());
		summaryEditUserForm.setSummary(userData.getSummary());
		
		List<SummaryModel> selectName = getStatus();
		
		model.addAttribute("summaryEditUserForm",summaryEditUserForm);
		model.addAttribute("selectName",selectName);
		return "summaryEditUser";
	}
	
	@RequestMapping(value = "/summaryEditUser/update/", method = RequestMethod.POST)
	public String summaryEditUserUpdate(Model model,@Validated @ModelAttribute SummaryEditUserForm summaryEditUserForm, BindingResult result) {
		
		List<String> errorList = new ArrayList<String>();
		
		if (result.hasErrors()) {
			List<SummaryModel> selectName = getStatus();
			model.addAttribute("summaryEditUserForm",summaryEditUserForm);
			model.addAttribute("selectName",selectName);
			return "summaryEditUser";
		}
		
		try {
			userService.SummaryUpdateUser(summaryEditUserForm);
		}catch (DuplicateKeyException e){
//			業務処理ユーザー重複
			errorList.add("ユーザーが重複しています。");
			model.addAttribute("validationError", errorList);
			return "summaryEditUser";
		}
		
		return "redirect:/summary/";
	}
	
	private List<SummaryModel>getStatus(){

		List<SummaryModel> list = new ArrayList<>();
		list.add(new SummaryModel(0,"選択"));
		list.add(new SummaryModel(1,"人事"));
		list.add(new SummaryModel(2,"インターン生"));
		return list;
		
	}
}
