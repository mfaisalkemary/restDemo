package com.spring.rest.restdemo.jpa;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import com.spring.rest.restdemo.jpa.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
List<User> findByRole(String role);
}
