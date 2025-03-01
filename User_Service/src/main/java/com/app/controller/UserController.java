package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("/test")
	public String test()
	{
		return "up and running";
	}

	@GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers()
	{
	   return service.getAllUsers();
	}
	
	
	@GetMapping("/id/{id}")
	@PreAuthorize("hasRole('USER')")
	public User getUserById( @PathVariable Long id)
	{
		return service.getById(id);
	}


	@DeleteMapping("/{uid}")
	@PreAuthorize("hasRole('ADMIN')")
	public User deleteById(@PathVariable Long uid)
	{
	   return service.deleteById(uid);
	}
}
