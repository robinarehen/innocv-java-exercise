package com.innocv.test.exercise.apicontroller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innocv.test.exercise.dto.ResponseDto;
import com.innocv.test.exercise.dto.UserDto;
import com.innocv.test.exercise.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserApiControllerImpl implements UserApiController {

	private UserServiceImpl userServiceImpl;
	private ResponseDto responseDto;

	public UserApiControllerImpl(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}

	@GetMapping
	@Override
	public ResponseEntity<ResponseDto> getAllUsers() {
		// TODO Auto-generated method stub
		this.getResponseDto("GET", "Users found", this.userServiceImpl.getAllUsers());
		return ResponseEntity.ok(this.responseDto);
	}
	
	@GetMapping("/{page}/{rows}")
	@Override
	public ResponseEntity<ResponseDto> getAllByPageable(Integer page, Integer rows) {
		Pageable pageable = PageRequest.of(page, rows);
		this.getResponseDto("GET", "Users found by Pageable", this.userServiceImpl.getAllByPageable(pageable));
		return ResponseEntity.ok(this.responseDto);
	}

	@GetMapping("/{ID}")
	@Override
	public ResponseEntity<ResponseDto> getUserById(Integer ID) {
		// TODO Auto-generated method stub
		this.getResponseDto("GET", "User found", this.userServiceImpl.getUserById(ID));
		return ResponseEntity.status(HttpStatus.FOUND).body(this.responseDto);
	}

	@PostMapping
	@Override
	public ResponseEntity<ResponseDto> createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		this.getResponseDto("CREATED", "User was created", this.userServiceImpl.createUser(userDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(this.responseDto);
	}

	@PutMapping
	@Override
	public ResponseEntity<ResponseDto> updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		this.getResponseDto("UPDATED", "User was updated", this.userServiceImpl.updateUser(userDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(this.responseDto);
	}

	@DeleteMapping("/{ID}")
	@Override
	public ResponseEntity<ResponseDto> deleteUser(Integer ID) {
		// TODO Auto-generated method stub
		this.userServiceImpl.deleteUser(ID);
		return ResponseEntity.ok(new ResponseDto("DELETE", "User was deleted", ""));
	}

	private ResponseDto getResponseDto(String status, String message, Object data) {
		this.responseDto = new ResponseDto(status, message, data);
		return this.responseDto;
	}

}
