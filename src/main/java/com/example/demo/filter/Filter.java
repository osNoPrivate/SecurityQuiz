package com.example.demo.filter;

import org.springframework.ui.Model;

import com.example.demo.entity.User;

public class Filter {
	
	public static boolean loginFilter(Model model,User loginUser) {
		if(loginUser == null) {
			String errorMessage = "不正なアクセスです";
			User user = new User();
			model.addAttribute("user",user);
			model.addAttribute("errorMessage", errorMessage);
			return false;
		}
		
		return true;
	}
}
