package com.innocv.test.exercise.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.innocv.test.exercise.dto.ResponseDto;
import com.innocv.test.exercise.dto.UserDto;

public interface UserApiController {

	ResponseEntity<ResponseDto> getAllUsers();
	
	ResponseEntity<ResponseDto> getAllByPageable(@PathVariable Integer page, @PathVariable Integer rows);

	ResponseEntity<ResponseDto> getUserById(@PathVariable Integer ID);

	ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto);

	ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto);

	ResponseEntity<ResponseDto> deleteUser(@PathVariable Integer ID);

}
