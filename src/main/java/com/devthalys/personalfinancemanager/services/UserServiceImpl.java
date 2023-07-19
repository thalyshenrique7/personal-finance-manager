package com.devthalys.personalfinancemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.exceptions.UserNotFoundException;
import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModel getUserByCpf(String cpf) {
		return this.userRepository.getUserByCpf(cpf);
	}

	@Override
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(UserModel user) {
		if(userRepository.existsUserByCpf(user.getCpf())) {
			throw new UserNotFoundException("User already exists.");
		}
		
		userRepository.save(user);
	}

	@Override
	public void delete(UserModel user) {
		userRepository.delete(user);
	}
	
	@Override
	public void update(UserModel user) {
		addWallet(user);
		userRepository.save(user);	
	}

	@Override
	public boolean existsUserByCpf(String cpf) {
		return userRepository.existsUserByCpf(cpf);
	}

	public void addWallet(UserModel user) {
		float currentWallet = user.getWallet();
		float walletValue = user.getAddValueToWallet();
		
		user.setAddValueToWallet(walletValue);
		
		float newValueToWallet = currentWallet + walletValue;
		
		user.setWallet(newValueToWallet);
	}
}
