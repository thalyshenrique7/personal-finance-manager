package com.devthalys.personalfinancemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devthalys.personalfinancemanager.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

//	@Query("select u from UserModel u left join fetch u.expenses where u.idUser = :idUser")
//	Optional<UserModel> findUserFetchExpenses(@Param("idUser") UUID id);
	
	UserModel getUserByCpf(String cpf);
	boolean existsUserByCpf(String cpf);
}
