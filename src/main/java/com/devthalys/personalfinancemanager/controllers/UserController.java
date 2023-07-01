package com.devthalys.personalfinancemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.services.UserServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<UserModel> findAll(){
		return userServiceImpl.findAll();
	}
	
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody UserModel user) {
		userServiceImpl.save(user);
	}
}
