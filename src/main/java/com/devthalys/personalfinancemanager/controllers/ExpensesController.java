package com.devthalys.personalfinancemanager.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devthalys.personalfinancemanager.models.ExpensesModel;
import com.devthalys.personalfinancemanager.services.ExpensesServiceImpl;

@RestController
@RequestMapping(value = "/expenses")
public class ExpensesController {

	@Autowired
	private ExpensesServiceImpl expensesServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Optional<ExpensesModel> findById(UUID id) {
		return expensesServiceImpl.findById(id);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody ExpensesModel expenses) {
		expensesServiceImpl.save(expenses);
	}
}
