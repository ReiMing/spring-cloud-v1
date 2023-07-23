package com.hx.startertest.hxspringbootstartertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hx.starter.hxspringbootstarterautoconfigurer.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloservice;
	
	@GetMapping("/hello")
	public String Hello() {
		return helloservice.sayHello("test");
	}
}
