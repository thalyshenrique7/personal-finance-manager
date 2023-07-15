package com.devthalys.personalfinancemanager.services;

import java.util.List;

import com.devthalys.personalfinancemanager.models.UserModel;

public interface UserService {
	
//	public Optional<UserModel> findUserFetchExpenses(UUID id);
	
	public UserModel getUserByCpf(String cpf);

	public List<UserModel> findAll();
	
	public void save(UserModel user);
	
	public void delete(UserModel user);
	
	public void update(UserModel user);
	
	boolean existsUserByCpf(String cpf);
}
