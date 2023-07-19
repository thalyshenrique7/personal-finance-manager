package com.devthalys.personalfinancemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthalys.personalfinancemanager.exceptions.UserNotFoundException;
import com.devthalys.personalfinancemanager.models.GoalModel;
import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.repositories.GoalRepository;
import com.devthalys.personalfinancemanager.repositories.UserRepository;

@Service
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<GoalModel> getAll() {
		return goalRepository.findAll();
	}

	@Override
	public void saveGoal(GoalModel goal) {
		UserModel getUser = userRepository.findById(goal.getUser().getIdUser()).orElse(null);
		if(getUser == null) {
			throw new UserNotFoundException("User not found.");
		}
		
		goal.setUser(getUser);
		
		goalRepository.save(goal);
	}

}
