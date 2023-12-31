package com.devthalys.personalfinancemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devthalys.personalfinancemanager.models.ExpensesModel;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesModel, Long>{

}
