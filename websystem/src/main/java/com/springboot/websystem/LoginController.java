package com.springboot.websystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private AuthenticationService authentication;
	
	@RequestMapping("/")
	public String welcome(ModelMap map) {
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		map.put("name", name);
		return "welcome";
		
//		if(authentication.authenticate(name, password)) {
//			map.put("name", name);
//			return "welcome";
//		} else {
//			map.put("errorMessage", "failed to login, please fill in the correct username and password");
//			return "login";
//		}
		
	}
	
//	@RequestMapping("signin")
//	public String login() {
//		
//		return "login";
//	}

}
