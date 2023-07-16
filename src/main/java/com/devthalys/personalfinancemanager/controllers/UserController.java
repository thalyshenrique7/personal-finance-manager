package com.devthalys.personalfinancemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devthalys.personalfinancemanager.dtos.AddWalletDTO;
import com.devthalys.personalfinancemanager.dtos.UserDTO;
import com.devthalys.personalfinancemanager.exceptions.UserNotFoundException;
import com.devthalys.personalfinancemanager.models.UserModel;
import com.devthalys.personalfinancemanager.services.UserServiceImpl;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<UserModel> findAll() {
		return userServiceImpl.findAll();
	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public UserModel findByUserFetchExpenses(@PathVariable UUID id) {
//		return userServiceImpl.findUserFetchExpenses(id)
//				.map(user -> {
//					user.getIdUser();
//					return user;
//				}).orElseThrow(() -> new UserNotFoundException("User not found."));
//	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserModel getUserByCpf(@PathVariable String cpf) {
		return this.userServiceImpl.getUserByCpf(cpf);
	}

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody UserModel user) {

		if (userServiceImpl.existsUserByCpf(user.getCpf())) {
			throw new UserNotFoundException("User already exists.");
		}

		userServiceImpl.save(user);
	}

	@Transactional
	@RequestMapping(value = "/delete/{userCpf}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UserModel userCpf) {
		UserModel find = userServiceImpl.getUserByCpf(userCpf.getCpf());

		if (find == null) {
			throw new UserNotFoundException("User not found.");
		}

		userServiceImpl.delete(find);
	}

	@Transactional
	@RequestMapping(value = "/update/{cpf}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String cpf, @RequestBody @Valid UserDTO userDto) {
		UserModel findCpf = userServiceImpl.getUserByCpf(cpf);

		findCpf.setFirstName(userDto.getFirstName());
		findCpf.setLastName(userDto.getLastName());
		findCpf.setAge(userDto.getAge());
		findCpf.setCpf(userDto.getCpf());
		findCpf.setWallet(userDto.getWallet());

		userServiceImpl.update(findCpf);
	}
	
	@Transactional
	@RequestMapping(value = "/update/wallet/{cpf}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateWallet(@PathVariable String cpf, @RequestBody @Valid AddWalletDTO userWallet) {
		UserModel findCpf = userServiceImpl.getUserByCpf(cpf);

		findCpf.setAddValueToWallet(userWallet.addValueToWallet());

		userServiceImpl.update(findCpf);
	}
}
