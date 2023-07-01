package com.devthalys.personalfinancemanager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<UserModel> findById(UUID id) {
		return userRepository.findById(id);
	}

	@Override
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(UserModel user) {
		userRepository.save(user);
	}

	@Override
	public void delete(UserModel user) {
		userRepository.delete(user);
	}

}
