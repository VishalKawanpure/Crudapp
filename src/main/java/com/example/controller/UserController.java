package com.example.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		User saveUser = this.userService.saveUser(user);

		return ResponseEntity.ok(saveUser);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> allUsers = this.userService.getAllUsers();

		return ResponseEntity.ok(allUsers);

	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<Optional<User>> getUserById(@RequestBody @PathVariable Integer userId) {

		Optional<User> userById = this.userService.getUserById(userId);

		return ResponseEntity.ok(userById);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer userId) {

		User updateUser = this.userService.updateUser(user, userId);
		return ResponseEntity.ok(updateUser);

	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@RequestBody @PathVariable Integer userId) throws Exception {

		this.userService.deleteUser(userId);
		return ResponseEntity.ok("deleted");
	}
	
	@GetMapping("/byname/{userName}")
	public ResponseEntity<List<User>> getUserListByName(@RequestBody @PathVariable String userName){
		
		List<User> userListByName = this.userService.getUserListByName(userName);
		return ResponseEntity.ok().body(userListByName);
	}
	
	@GetMapping("/bycity/{userCity}")
	public ResponseEntity<List<User>> getUserListByCity(@RequestBody @PathVariable String userCity){
		
		List<User> userListByCity = this.userService.getUserListByCity(userCity);
		
		return ResponseEntity.ok().body(userListByCity);
		 
		
	}
}
