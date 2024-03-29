package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.feignclient.UserClient;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserClient userclient;

	
	public User getUserDetails(Long userId)
	{
		return userclient.getUserById(userId);
	}
}
