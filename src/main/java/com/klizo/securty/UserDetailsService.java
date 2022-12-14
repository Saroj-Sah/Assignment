package com.klizo.securty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.klizo.repository.UserRepository;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
    private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

}
