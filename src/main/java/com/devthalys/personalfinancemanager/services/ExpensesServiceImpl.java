package com.devthalys.personalfinancemanager.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.models.ExpensesModel;
import com.devthalys.personalfinancemanager.repositories.ExpensesRepository;

@Service
public class ExpensesServiceImpl implements ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;
	
	@Override
	public Optional<ExpensesModel> findById(UUID id) {
		return expensesRepository.findById(id);
	}

	@Override
	public void save(ExpensesModel expenses) {
		expensesRepository.save(expenses);
	}

}
