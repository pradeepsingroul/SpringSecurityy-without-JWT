package com.Security.Congif;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
	@Bean
	public SecurityFilterChain mySecurityFilterChain(HttpSecurity https) throws Exception{
		
		https.authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/register")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable()
		.formLogin()
		.and()
		.httpBasic();
		
		return https.build();
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
