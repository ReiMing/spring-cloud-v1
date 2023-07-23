package com.springcloud.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellowroldController {

	
	@Value("${min}")
	String min;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello " + min;
	}
}
