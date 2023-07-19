package com.devthalys.personalfinancemanager.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "goals")
public class GoalModel implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGoal;
	
	@Column
	private String goalName;
	
	@Column
	private float goalFinance;
	
	@ManyToOne
	@JoinColumn(name = "user_goals_id")
	@JsonBackReference
	private UserModel user;

	public Long getIdGoal() {
		return idGoal;
	}

	public void setIdGoal(Long idGoal) {
		this.idGoal = idGoal;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public float getGoalFinance() {
		return goalFinance;
	}

	public void setGoalFinance(float goalFinance) {
		this.goalFinance = goalFinance;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
}
