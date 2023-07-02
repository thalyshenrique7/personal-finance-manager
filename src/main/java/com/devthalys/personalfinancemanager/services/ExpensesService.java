package com.devthalys.personalfinancemanager.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.models.ExpensesModel;

@Service
public interface ExpensesService {

	public Optional<ExpensesModel> findById(UUID id);
	
	public void saveExpenses(ExpensesModel expenses);
}
