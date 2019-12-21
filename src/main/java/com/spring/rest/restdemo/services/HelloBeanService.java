package com.spring.rest.restdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.restdemo.hellobean.HelloBean;

@Service
public class HelloBeanService {

	@Autowired
	HelloBean bean;
	
	public  HelloBean returnHelloBean(String msg) {
		bean.setMessgae("hello "+msg+" welcome to the helloBean service");
		return bean;
	//	return new HelloBean("this bean message was set and returned from a service");
	}
	
	
}
