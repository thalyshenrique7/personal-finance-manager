package com.devthalys.personalfinancemanager.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.PersonalFinanceManagerApplication;
import com.devthalys.personalfinancemanager.models.ExpensesModel;
import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.repositories.ExpensesRepository;
import com.devthalys.personalfinancemanager.repositories.UserRepository;

@Service
public class ExpensesServiceImpl implements ExpensesService {
	
	private static Logger logger = LoggerFactory.getLogger(PersonalFinanceManagerApplication.class);
	
	private final String USER_NOT_FOUND = "User not found";

	@Autowired
	private ExpensesRepository expensesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<ExpensesModel> findById(UUID id) {
		return expensesRepository.findById(id);
	}

	@Override
	public void saveExpenses(ExpensesModel expenses) {
		UserModel user = userRepository.findById(expenses.getUser().getIdUser()).orElse(null);
		if ( user == null ) {
			logger.error(USER_NOT_FOUND);
		}
		
		expenses.setUser(user);
		expenses.setExpensesDate(LocalDateTime.now());
		
		expensesRepository.save(expenses);
	}

}
