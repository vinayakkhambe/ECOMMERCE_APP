package com.app.jwt;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;




@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtAuthenticationHelper helper;
	
	@Autowired
	UserDetailsService custuserdetailservice;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestheader = request.getHeader("Authorization");
		
		String username = null;
		String token = null;
		
		//Bearer afasfasfsafasf
		
		if(requestheader !=null && requestheader.startsWith("Bearer"))
		{
			token = requestheader.substring(7);
		    username = helper.getUserNameFromToken(token);
		    
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
				UserDetails userDetails = custuserdetailservice.loadUserByUsername(username);
				
				if(!helper.isTokenExpired(token))
				{
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(token, null,userDetails.getAuthorities());
					
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
				
			}
		}
		  filterChain.doFilter(request, response);
		
	
		
	}

}