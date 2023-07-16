package com.devthalys.personalfinancemanager.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idUser;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private int age;
	
	@Column
	private String cpf;
	
	@Column
	private float wallet;
	
	@Column(nullable = true)
	@JsonIgnore
	private float addValueToWallet;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExpensesModel> expenses;

	public UserModel() {}

	public UserModel(UUID idUser, String firstName, String lastName, int age, String cpf, float wallet) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.cpf = cpf;
		this.wallet = wallet;
	}

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	public float getAddValueToWallet() {
		return addValueToWallet;
	}

	public void setAddValueToWallet(float addValueToWallet) {
		this.addValueToWallet = addValueToWallet;
	}

	public List<ExpensesModel> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpensesModel> expenses) {
		this.expenses = expenses;
	}

	
}
