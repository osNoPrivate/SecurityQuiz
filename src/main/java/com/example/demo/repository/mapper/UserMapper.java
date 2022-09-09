package com.example.demo.repository.mapper;

import java.util.List;

import com.example.demo.entity.User;

public interface UserMapper {
	
	void insertUser(User user);
	
	User checkUser(User user);
	
	List<User> allUser();
	
	void deleteUser(User user);
	
	void updateUser(User user);
	
	User selectUser(User user);

}
