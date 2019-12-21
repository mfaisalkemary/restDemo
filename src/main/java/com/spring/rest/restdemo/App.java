package com.spring.rest.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.rest.restdemo.utils.FromExcelToCsv;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
	
    public static void main( String[] args )
    {
    	ApplicationContext ctx = SpringApplication.run(App.class, args);
    	
    }
}
