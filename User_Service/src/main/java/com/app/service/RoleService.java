package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Role;
import com.app.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	RoleRepository repository;
	
	public String createRole(Role r)
	{
	    repository.save(r);	
		return "role created";
	}

}
