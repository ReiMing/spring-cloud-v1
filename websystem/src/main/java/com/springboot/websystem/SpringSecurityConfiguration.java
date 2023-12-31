package com.springboot.websystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("TIM")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
		
	}
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception{
		
		http.authorizeRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
