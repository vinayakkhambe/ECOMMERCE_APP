package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.UserRequest;
import com.app.Entity.User;
import com.app.Service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    UserService service; 
	
	
	@GetMapping("/all")
	public List<User> getAllUsers()
	{
		return service.getAllUsers();
	}
	
	@GetMapping("/test")
	@PreAuthorize("hasRole('ADMIN')")
	public String test()
	{
		return "test";
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserRequest req)
	{
		service.addUser(req);
		return req.toString();
	}

}
