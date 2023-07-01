package com.devthalys.personalfinancemanager.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.devthalys.personalfinancemanager.enums.ExpensesCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class ExpensesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idExpenses;
	
	@Column
	private String expensesName;
	
	@Enumerated(EnumType.STRING)
	private ExpensesCategory expensesCategory;
	
	@Column
	private float expensesValue;
	
	@Column
	private LocalDateTime expensesDate;
	
	@Column
	private String expensesDescription;
	
	@ManyToOne
	private UserModel user;
}
