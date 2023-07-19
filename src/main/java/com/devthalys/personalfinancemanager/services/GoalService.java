package com.devthalys.personalfinancemanager.services;

import java.util.List;

import com.devthalys.personalfinancemanager.models.GoalModel;

public interface GoalService {

	public List<GoalModel> getAll();
	
	public void saveGoal(GoalModel goal);
}
