package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.Dto.UserRequest;
import com.app.Entity.User;
import com.app.Repository.UserRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	
	public List<User> getAllUsers()
	{
		return repository.findAll();
	}
	
	public void addUser(UserRequest request)
	{
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
		
		User u = new User();
		u.setUsername(request.getUsername());
		u.setEmail(request.getEmail());
		u.setPassword(encodedPassword);
		u.setRoles(request.getRoles());
		
		repository.save(u);
	}

}
