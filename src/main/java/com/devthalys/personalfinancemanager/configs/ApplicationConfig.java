package com.devthalys.personalfinancemanager.configs;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

import com.devthalys.personalfinancemanager.mapper.UserMapper;

//@Configuration
public class ApplicationConfig {

	@Bean
	public UserMapper getMapper() {
		return Mappers.getMapper(UserMapper.class);
	}
}
