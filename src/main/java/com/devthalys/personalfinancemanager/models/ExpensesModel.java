package com.devthalys.personalfinancemanager.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.devthalys.personalfinancemanager.enums.ExpensesCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class ExpensesModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idExpenses;
	
	@Column
	private String expensesName;
	
	@Enumerated(EnumType.STRING)
	private ExpensesCategory expensesCategory;
	
	@Column
	private float limitToSpending;
	
	@Column
	private float expensesValue;
	
	@Column
	private float totalExpenses;
	
	@Column
	private LocalDateTime expensesDate;
	
	@Column
	private String expensesDescription;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private UserModel user;
	
	public ExpensesModel() {}

	public ExpensesModel(Long idExpenses, String expensesName, ExpensesCategory expensesCategory, float expensesValue,
			LocalDateTime expensesDate, String expensesDescription, UserModel user) {
		super();
		this.idExpenses = idExpenses;
		this.expensesName = expensesName;
		this.expensesCategory = expensesCategory;
		this.expensesValue = expensesValue;
		this.expensesDate = expensesDate;
		this.expensesDescription = expensesDescription;
		this.user = user;
	}

	public Long getIdExpenses() {
		return idExpenses;
	}

	public void setIdExpenses(Long idExpenses) {
		this.idExpenses = idExpenses;
	}

	public String getExpensesName() {
		return expensesName;
	}

	public void setExpensesName(String expensesName) {
		this.expensesName = expensesName;
	}

	public ExpensesCategory getExpensesCategory() {
		return expensesCategory;
	}

	public void setExpensesCategory(ExpensesCategory expensesCategory) {
		this.expensesCategory = expensesCategory;
	}

	public float getExpensesValue() {
		return expensesValue;
	}

	public void setExpensesValue(float expensesValue) {
		this.expensesValue = expensesValue;
	}

	public LocalDateTime getExpensesDate() {
		return expensesDate;
	}

	public void setExpensesDate(LocalDateTime expensesDate) {
		this.expensesDate = expensesDate;
	}

	public String getExpensesDescription() {
		return expensesDescription;
	}

	public void setExpensesDescription(String expensesDescription) {
		this.expensesDescription = expensesDescription;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public float getLimitToSpending() {
		return limitToSpending;
	}

	public void setLimitToSpending(float limitToSpending) {
		this.limitToSpending = limitToSpending;
	}

	public float getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(float totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	
}
