package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.User;

public interface UserService {
	
	
	public User saveUser(User user); 
	
	public List<User> getAllUsers();
	
	public List<User> getUserListByName(String userName);
	
	public List<User> getUserListByCity(String userCity);
	
	public Optional<User> getUserById(Integer userId);
	
	public User updateUser(User user,Integer userId );
	
	public void deleteUser(Integer userId);
	
	
	
	
	

}
