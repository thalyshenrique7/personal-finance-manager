package com.devthalys.personalfinancemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devthalys.personalfinancemanager.models.GoalModel;

@Repository
public interface GoalRepository extends JpaRepository<GoalModel, Long> {

}
