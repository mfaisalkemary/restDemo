package com.spring.rest.restdemo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Value("${welcome.message1}")
	private String message;
	
	public String sayHello() {
		return message;
	}
}
