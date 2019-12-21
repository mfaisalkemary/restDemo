package com.spring.rest.restdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.restdemo.hellobean.HelloBean;
import com.spring.rest.restdemo.services.HelloBeanService;
import com.spring.rest.restdemo.services.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	HelloService service;
	
	@Autowired
	HelloBeanService hellobeanservice;
	
	
	@RequestMapping(value = "hello")
	public String sayHello() {
		//return "hello from controller";
		return service.sayHello();
	}
	
	@GetMapping(value = "helloBean/{name}")
	public HelloBean returnhelloBean(@PathVariable String name) {
		return hellobeanservice.returnHelloBean(name);
//		return new HelloBean("this messgae is set by the controller");
	}
}
