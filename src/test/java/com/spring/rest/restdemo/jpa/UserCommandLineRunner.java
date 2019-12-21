package com.spring.rest.restdemo.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	
	private static final Logger log= LoggerFactory.getLogger(UserCommandLineRunner.class);

	public void run(String... args)  {
		repository.save(new User("mohamed","admin"));
		repository.save(new User("mazen","moderator"));
		repository.save(new User("zain","user"));
		repository.save(new User("mohamed1","admin"));
		repository.save(new User("mazen1","admin"));
		repository.save(new User("zain1","admin"));
		
//		for (User user:repository.findByRole("admin")) {
//			log.info(user.toString());
//		}
			
		}
	
	
	

}
