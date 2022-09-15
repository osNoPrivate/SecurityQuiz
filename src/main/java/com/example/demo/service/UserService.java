package com.example.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.form.EditUserForm;
import com.example.demo.form.SummaryEditUserForm;
import com.example.demo.form.UserForm;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void insertUser(UserForm userForm) {
//		passwordをハッシュ化
		String password = encrypt(userForm.getPassword());
		User user = new User();
		user.setAccount(userForm.getAccount());
		user.setName(userForm.getName());
		user.setPassword(password);
		user.setSummary(userForm.getSummary());
		userRepository.insertUser(user);
	}
	
	public User checkUser(User user){
//		passwordをハッシュ化
		user.setPassword(encrypt(user.getPassword()));
		return userRepository.checkUser(user);
	}
	
	public List<User> allUser(){
		return userRepository.allUser();
	}
	
	public void deleteUser(User user) {
		userRepository.deleteUser(user);
	}
	
	public void SummaryUpdateUser(SummaryEditUserForm summaryEditUserForm) {
		
		User user = new User();
		user.setId(summaryEditUserForm.getId());
		user.setAccount(summaryEditUserForm.getAccount());
		user.setName(summaryEditUserForm.getName());
		user.setPassword(summaryEditUserForm.getPassword());
		user.setSummary(summaryEditUserForm.getSummary());
		
		userRepository.updateUser(user);
	}
	
	public void allApdateUser(EditUserForm editUserForm) {
		User user = new User();
		user.setId(editUserForm.getId());
		user.setAccount(editUserForm.getAccount());
		user.setName(editUserForm.getName());
		user.setSummary(editUserForm.getSummary());
		
		if(!StringUtils.isBlank(editUserForm.getPassword())) {
			user.setPassword(encrypt(editUserForm.getPassword()));
		}else {
			User userData = selectUser(user);
			user.setPassword(userData.getPassword());
		}
		
		userRepository.updateUser(user);
	}
	
	public User selectUser (User user) {
		return userRepository.selectUser(user);
	}
	
//	passwordのハッシュ化メソッド
	public static String encrypt(String target) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(target.getBytes());
			return Base64.encodeBase64URLSafeString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
