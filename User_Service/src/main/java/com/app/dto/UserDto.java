package com.app.dto;

import java.util.HashSet;
import java.util.Set;

import com.app.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Set<Role> roles = new HashSet<>();
}
