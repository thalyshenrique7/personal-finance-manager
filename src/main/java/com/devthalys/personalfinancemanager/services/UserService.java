package com.devthalys.personalfinancemanager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.models.UserModel;

@Service
public interface UserService {
	
	public Optional<UserModel> findById(UUID id);

	public List<UserModel> findAll();
	
	public void save(UserModel user);
	
	public void delete(UserModel user);
}
