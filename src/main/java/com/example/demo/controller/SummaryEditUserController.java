package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.SummaryEditUserForm;
import com.example.demo.form.SummaryUserData;
import com.example.demo.service.UserService;

@Controller
public class SummaryEditUserController {

	@Autowired
	public HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/summaryEditUser/", method = RequestMethod.POST)
	public String summaryEditUser(Model model,@ModelAttribute SummaryUserData userData) {
		
		SummaryEditUserForm summaryEditUserForm = new SummaryEditUserForm();
		summaryEditUserForm.setId(userData.getId());
		summaryEditUserForm.setAccount(userData.getAccount());
		summaryEditUserForm.setName(userData.getName());
		summaryEditUserForm.setPassword(userData.getPassword());
		summaryEditUserForm.setSummary(userData.getSummary());
		
		model.addAttribute("summaryEditUserForm",summaryEditUserForm);
		return "summaryEditUser";
	}
	
	@RequestMapping(value = "/summaryEditUser/update/", method = RequestMethod.POST)
	public String summaryEditUserUpdate(Model model,@Validated @ModelAttribute SummaryEditUserForm summaryEditUserForm, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("summaryEditUserForm",summaryEditUserForm);
			return "summaryEditUser";
		}
		userService.SummaryUpdateUser(summaryEditUserForm);
		return "redirect:/summary/";
	}
	
}
