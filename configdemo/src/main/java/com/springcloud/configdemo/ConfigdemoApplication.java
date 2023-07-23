package com.springcloud.configdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigdemoApplication.class, args);
	}

}
