package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;	
	public User login(String userName, String userPass) {
		System.out.println("---------�ϰ�....�ҿ�ʼ�ɻ���  ------");
		return userMapper.login(userName, userPass);
	}
}
