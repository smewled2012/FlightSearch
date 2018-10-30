package com.employee.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.User;
import com.employee.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	
	@Autowired
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository =  userRepository;
	}
	
	
	/* saving a user */ 
	
	public User save(User user) {
		
		return userRepository.save(user);
	}
	
	
	/* to get the list of all users  */
	
	public Iterable<User> findAll(){
		
		return  userRepository.findAll();	
	}
	
	
	/* to get a user by id */
	
	public User findOne(int userid) {
		
		return userRepository.findOne(userid);
		}
	
	/* delete an user */
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	
	

}
