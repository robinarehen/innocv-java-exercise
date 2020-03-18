package com.innocv.test.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.innocv.test.exercise.dto.UserDto;
import com.innocv.test.exercise.entity.UserEntity;
import com.innocv.test.exercise.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<UserDto> createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		UserEntity entity = this.dtoToEntity(userDto);
		UserEntity entitySaved = this.userRepository.save(entity);
		return this.entityToDto(entitySaved);
	}

	@Override
	public Optional<UserDto> updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		this.userRepository.findById(userDto.getId())
				.orElseThrow(() -> new IllegalArgumentException("ID is not valid"));

		UserEntity entity = this.dtoToEntity(userDto);
		entity.setId(userDto.getId());
		UserEntity entitySaved = this.userRepository.save(entity);

		return this.entityToDto(entitySaved);
	}

	@Override
	public void deleteUser(UserDto userDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDto> getUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	private Optional<UserDto> entityToDto(UserEntity entity) {
		UserDto userDto = new UserDto(entity.getName(), entity.getBirthDate());
		userDto.setId(entity.getId());
		return Optional.of(userDto);
	}

	private UserEntity dtoToEntity(UserDto userDto) {
		return new UserEntity(userDto.getName(), userDto.getBirthDate());
	}
}
