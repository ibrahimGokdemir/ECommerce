package com.ibra.ECommerce.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibra.ECommerce.dto.UserDTO;
import com.ibra.ECommerce.model.User;
import com.ibra.ECommerce.service.UserService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController{
	
	
	private final UserService userService;
	

	
	//Tüm kullanıcıları getirir
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	//Belirli kullanıcıyı getirir
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id")Long id) {
		User user = userService.GetUserById(id);
		return ResponseEntity.ok(user);
	}
	
	//Yeni kullanıcı oluşturan
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
		User createdUser = userService.createUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	//Varolan kullanıcıyı güncelleştiren
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody UserDTO userDTO){
		
		User updateUser = userService.updateUser(id, userDTO);
		return ResponseEntity.ok(updateUser);
	}
	
	//Belirli kullanıcıyı silen endpoint
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
		
	}
	
	
	
	
	
	
	
