package com.devthalys.personalfinancemanager.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devthalys.personalfinancemanager.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

}
