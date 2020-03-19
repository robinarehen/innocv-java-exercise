package com.innocv.test.exercise.service;

import java.util.List;
import java.util.Optional;

import com.innocv.test.exercise.dto.UserDto;

public interface UserService {

	Optional<UserDto> createUser(UserDto userDto);
	
	Optional<UserDto> updateUser(UserDto userDto);
	
	void deleteUser(Integer ID);
	
	List<UserDto> getAllUsers();
	
	Optional<UserDto> getUserById(Integer ID);
}
