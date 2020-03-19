package com.innocv.test.exercise.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innocv.test.exercise.dto.UserDto;
import com.innocv.test.exercise.entity.UserEntity;
import com.innocv.test.exercise.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	@Autowired
	private ObjectMapper userMapper;

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
	public void deleteUser(Integer ID) {
		// TODO Auto-generated method stub
		this.userRepository.findById(ID).orElseThrow(() -> new IllegalArgumentException("ID is not valid"));

		this.userRepository.deleteById(ID);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll().stream().map(entity -> {
			return this.entityToDto(entity).get();
		}).collect(Collectors.toList());
	}

	public Page<Optional<UserDto>> getAllByPageable(Pageable pageable) {
		return this.userRepository.findAll(pageable).map(this::entityToDto);
	}

	@Override
	public Optional<UserDto> getUserById(Integer ID) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(ID).map(entity -> {
			return this.entityToDto(entity);
		}).orElseThrow(() -> new IllegalArgumentException("ID is not valid"));
	}

	private Optional<UserDto> entityToDto(UserEntity entity) {
		return Optional.of(this.userMapper.convertValue(entity, UserDto.class));
	}

	private UserEntity dtoToEntity(UserDto userDto) {
		return this.userMapper.convertValue(userDto, UserEntity.class);
	}
}
