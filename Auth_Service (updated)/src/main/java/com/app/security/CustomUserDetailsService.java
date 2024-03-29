package com.app.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.Entity.User;
import com.app.Repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userrepo;
	
	public CustomUserDetailsService(UserRepository repo) 
	{
		this.userrepo = repo;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//	User u = userrepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid User email !!!!!"));
		//return new MyUserDetails(u);
		return this.userrepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}

}
