package com.employee.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.User;
import com.employee.service.UserService;

@RestController 
@RequestMapping("/company")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/*   this basically guides and directs towards the user service 
	 * where the methods to perform a specific task is defined */
	
	/*to save a user   we use a HTTP verb of Post with a body */
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		
		return userService.save(user);
		
	}
	
	
	/* get the list of all users */
	
	@GetMapping("/users")
	public Iterable<User> getAllUsers(){
		return userService.findAll();
	}
	
	/* get a user by id*/
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value="id") Integer userid){
		User user =userService.findOne(userid);
		
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	/*update a user by id */

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Integer userid, @Valid @RequestBody User userDetails){
		
		User user = userService.findOne(userid);
		
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setExpertise(userDetails.getExpertise());
		user.setPosition(userDetails.getPosition());
		
		User updateUser = userService.save(user);
		return ResponseEntity.ok().body(updateUser);	
	
	}
	
	
	/* Delete a User */
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity <User> deleteUser(@PathVariable(value="id") int userid){
		User user = userService.findOne(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		
		userService.delete(user);
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
