//package com.app.security;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.app.Entity.User;
//
//
//
//public class MyUserDetails implements UserDetails {
//	
//	private User user;
//	
//	public MyUserDetails(User user) {
//		super();
//		this.user = user;
//		System.out.println("inside myuserdeails :" + user.getRoles().toString());
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		//return List.of(new SimpleGrantedAuthority(user.getRole().name()));
//		
//		return this.user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole()))
//				.collect(Collectors.toList());
//		
//	}
//
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return user.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;//user a/c is not expired 
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}