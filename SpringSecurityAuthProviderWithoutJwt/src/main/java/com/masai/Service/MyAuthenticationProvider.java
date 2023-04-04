package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private PasswordEncoder pEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication){
		
		String username =authentication.getName();
		
		String pwd = authentication.getCredentials().toString();
		
		Optional<Customer> opt = customerRepo.findByEmail(username);
		
		if(!opt.isPresent()) {
			throw new BadCredentialsException("no user exit");
		}else {
			
			Customer customer  =opt.get();
			
			if(pEncoder.matches(pwd,customer.getPassword())) {
				
				List<GrantedAuthority> authorities = new ArrayList<>();
				
				return new UsernamePasswordAuthenticationToken(customer,pwd, authorities);
				
			}
		else {
			throw new BadCredentialsException("invalid password");
		}
		}
		
	}
	
	@Override
	public boolean supports(Class<?> authentication) {

	return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

	}
	
	
	
	
	

}
