package com.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.app.dto.LoginResponseDto;
import com.app.dto.UserDto;
import com.app.service.AuthService;
import com.app.service.UserService;

import javax.*;
import javax.validation.Valid;

import com.app.dto.LoginRequestDto;



@RestController
@RequestMapping("/user/auth")
public class AuthController {
	
	@Autowired
	UserService service;
	
	@Autowired
	AuthService authservice;

	
	@GetMapping("/validate")
	public boolean validate( @RequestParam("token")String token)
	{
		
		     return authservice.validate(token);
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "service is up and running";
	}

	@PostMapping("/signin")
	public LoginResponseDto login (@Valid @RequestBody LoginRequestDto dto)
	{	
		return authservice.login(dto);
	}
	
	@PostMapping("/signup")
	public String authenticateUser (@Valid @RequestBody UserDto dto)
	{
		return service.registerUser(dto);
	}
}


