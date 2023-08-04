package com.devthalys.personalfinancemanager.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.PersonalFinanceManagerApplication;
import com.devthalys.personalfinancemanager.enums.ExpensesCategory;
import com.devthalys.personalfinancemanager.models.ExpensesModel;
import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.repositories.ExpensesRepository;
import com.devthalys.personalfinancemanager.repositories.UserRepository;

@Service
public class ExpensesServiceImpl implements ExpensesService {

	private static Logger logger = LoggerFactory.getLogger(PersonalFinanceManagerApplication.class);

	private final String USER_NOT_FOUND = "User not found";
	private final String LIMIT_EXCEEDED = "Limit spending to category exceeded!";

	@Autowired
	private ExpensesRepository expensesRepository;

	@Autowired
	private UserRepository userRepository;

	public List<ExpensesModel> findAll() {
		return expensesRepository.findAll();
	}

	@Override
	public Optional<ExpensesModel> findById(Long id) {
		return expensesRepository.findById(id);
	}

	@Override
	public void saveExpenses(ExpensesModel expenses) {
		UserModel user = userRepository.findById(expenses.getUser().getIdUser()).orElse(null);
		if (user == null) {
			logger.error(USER_NOT_FOUND);
		}

		expenses.setUser(user);
		expenses.setExpensesDate(LocalDateTime.now());
		calculateWalletToExpenses(expenses, user);
		warnAboutWallet(user);

		expensesRepository.save(expenses);
	}

	@Override
	public void updateExpenses(ExpensesModel expenses) {
		calculateWalletToExpenses(expenses, expenses.getUser());
		limitSpendingToCategory(expenses);
		warnAboutWallet(expenses.getUser());
		expensesRepository.save(expenses);
	}

	public void calculateWalletToExpenses(ExpensesModel expenses, UserModel user) {
		ExpensesCategory category = expenses.getExpensesCategory();
		float currentWallet = user.getWallet();

		for (ExpensesCategory cat : category.values()) {
			float totalWallet = currentWallet - expenses.getExpensesValue();
			user.setWallet(totalWallet);
		}
	}

	public void limitSpendingToCategory(ExpensesModel expenses) {
		float limit = expenses.getLimitToSpending();

		if (expenses.getExpensesValue() > expenses.getLimitToSpending()) {
			logger.error(LIMIT_EXCEEDED + limit);
		}
	}
	
	public void warnAboutWallet(UserModel user) {
		if(user.getWallet() < 100) {
			System.out.println("Wallet less than 100 credits. If you want, you can add more credits in you wallet!");
		}
	}

	@Override
	public void delete(ExpensesModel expenses) {
		expensesRepository.delete(expenses);
	}

}
