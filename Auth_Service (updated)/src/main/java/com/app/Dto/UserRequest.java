package com.app.Dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.app.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserRequest {
	
	private String username;
	private String password;
	private String email;
	private  Set<Role> roles = new HashSet<>();



}
