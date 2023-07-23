package com.springboot.websystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontController {

	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		
		return "hello springboot";
	}
}
