package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.repository.mapper.UserMapper;

@Repository
public class UserRepository {
	
	@Autowired
	private UserMapper userMapper;
	
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
	
	public User checkUser(User user){
		return userMapper.checkUser(user);
	}
	
	public List<User> allUser() {
		return userMapper.allUser();
	}
	
	public void deleteUser(User user) {
		userMapper.deleteUser(user);
	}
	
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	
	public User selectUser(User user) {
		return userMapper.selectUser(user);
	}

}
