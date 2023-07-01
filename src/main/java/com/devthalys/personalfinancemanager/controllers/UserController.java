package com.devthalys.personalfinancemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.services.UserServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping(value = "/")
	public List<UserModel> findAll(){
		return userServiceImpl.findAll();
	}
	
	@Transactional
	@PostMapping(value = "/save")
	public void save(@RequestBody UserModel user) {
		userServiceImpl.save(user);
	}
}
