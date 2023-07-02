package com.devthalys.personalfinancemanager.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devthalys.personalfinancemanager.models.ExpensesModel;
import com.devthalys.personalfinancemanager.services.ExpensesServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/expenses")
public class ExpensesController {

	@Autowired
	private ExpensesServiceImpl expensesServiceImpl;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Optional<ExpensesModel> findById(@PathVariable UUID id) {
		return expensesServiceImpl.findById(id);
	}
	
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody ExpensesModel expenses) {
		expensesServiceImpl.saveExpenses(expenses);
	}
}
