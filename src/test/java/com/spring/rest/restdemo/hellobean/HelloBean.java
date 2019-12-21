package com.spring.rest.restdemo.hellobean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloBean {

	@Value("${beanwelcomemessage}")
    private String messgae;
//
//public void setMessgae(String messgae) {
//	this.messgae = messgae;
//}

public HelloBean(String messgae) {
	super();
	this.messgae = messgae;
}

public HelloBean() {
	super();
	// TODO Auto-generated constructor stub
}

public String getMessgae() {
	return messgae;
}

public void setMessgae(String messgae) {
	this.messgae = messgae;
}





}
