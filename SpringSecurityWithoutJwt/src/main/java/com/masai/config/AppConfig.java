package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
	
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST,"/customers")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.formLogin()
		.and()
		.httpBasic();
		
		
		return http.build();
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

/*
 This code snippet represents a method in a Spring Security configuration class that is responsible for 
 setting up the security filter chain. The security filter chain is a series of filters that process incoming
  requests and outgoing responses to ensure that they meet the security requirements defined by the 
  application.

The method takes an instance of HttpSecurity, which is used to configure the security filters. 
The HttpSecurity object provides methods to configure various aspects of the security filter chain.

In this particular code snippet, the method starts by calling the authorizeHttpRequests() method to set
 up authorization rules for all incoming requests. The next line permits all HTTP POST requests to 
 the "/customers" endpoint without authentication by calling the permitAll() method.

The anyRequest() method is then called to set up authentication for all other requests that do not match
 the previous rule. The authenticated() method is called to specify that authentication is required for 
 these requests.

The method then disables CSRF protection by calling the csrf().disable() method. CSRF (Cross-Site Request
 Forgery) protection is a security feature that prevents unauthorized requests from being sent to the server.

The method then sets up form-based authentication by calling the formLogin() method. This is used to 
authenticate users through a login form in a web page.

Finally, the httpBasic() method is called to set up Basic Authentication. This is a type of authentication
 where the username and password are sent in the HTTP headers. It is typically used when making requests 
 from command-line tools or REST clients like Postman.

The method returns the HttpSecurity object by calling the build() method, which builds the final security
 filter chain.
*/
