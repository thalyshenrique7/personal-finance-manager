package com.devthalys.personalfinancemanager.mapper;

import com.devthalys.personalfinancemanager.dtos.UserDTO;
import com.devthalys.personalfinancemanager.models.UserModel;

//@Mapper(componentModel = "spring") // Por estar dentro do spring deve ser anotado, caso for usar dentro do java, não precisa.
public interface UserMapper {
	
	UserDTO userToUserDTO(UserModel user);
	
}
