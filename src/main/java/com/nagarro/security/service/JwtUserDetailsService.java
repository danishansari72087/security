package com.nagarro.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> list = new ArrayList<>();

		if ("user".equals(username)) {
	        list.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("user", "$2a$10$5NQadW5BySWsRfwOv9UohOXaTCxUDAl9XzPPJ6J3p1dU1XXmjlCVu",list);
		}else if ("admin".equals(username)) {
	        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin", "$2a$10$lFcYRg5NLNi322mSTcvb5OLxQJXv6A0DJXAA8s.NEy6SWPMINwwBW", list);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}