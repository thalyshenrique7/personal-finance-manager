package com.devthalys.personalfinancemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devthalys.personalfinancemanager.models.GoalModel;
import com.devthalys.personalfinancemanager.services.GoalServiceImpl;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/goals")
public class GoalController {
	
	@Autowired
	private GoalServiceImpl goalServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<GoalModel> getAll(){
		return goalServiceImpl.getAll();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveGoal(GoalModel goal) {
		goalServiceImpl.saveGoal(goal);
	}
}
