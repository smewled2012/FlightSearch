package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findOne(int userid);

}
