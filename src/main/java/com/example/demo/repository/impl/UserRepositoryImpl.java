package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.mapper.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private final UserMapper userMapper;
	
	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public void insertUser(User user) {
		this.userMapper.insertUser(user);
	}

	@Override
	public User checkUser(User user) {
		return this.userMapper.checkUser(user);
	}
	
	@Override
	public List<User> allUser(){
		return this.userMapper.allUser();
	}
	
	@Override
	public void deleteUser(User user) {
		this.userMapper.deleteUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		this.userMapper.updateUser(user);
	}
	
	@Override
	public User selectUser(User user) {
		return this.userMapper.selectUser(user);
	}
}
