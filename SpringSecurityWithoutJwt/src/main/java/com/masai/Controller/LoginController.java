package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailHandler(Authentication auth){
		
		 Customer customer = customerRepo.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("invalid Username and Password"));
		 
		 return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
	
	

}
