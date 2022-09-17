package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepository;
import com.example.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {

		return this.userRepository.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Integer userId) {

		Optional<User> findById = this.userRepository.findById(userId);

		return findById;

	}

	@SuppressWarnings("deprecation")
	@Override
	public User updateUser(User user, Integer userId) {

		User byId = this.userRepository.getById(userId);

		byId.setName(user.getName());
		byId.setCity(user.getCity());
		byId.setMobile(user.getMobile());

		User save = this.userRepository.save(byId);

		return save;

	}

	@Override
	public void deleteUser(Integer userId) {
		this.userRepository.deleteById(userId);

	}

	@Override
	public List<User> getUserListByName(String userName) {
		return this.userRepository.getUserListByName(userName);
	}

	@Override
	public List<User> getUserListByCity(String userCity) {
		return this.userRepository.getUserListByCity(userCity);
	}

}
