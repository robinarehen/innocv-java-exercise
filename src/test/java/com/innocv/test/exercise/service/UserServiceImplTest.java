package com.innocv.test.exercise.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.innocv.test.exercise.dto.UserDto;

@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Test
	public void createUser() {

		UserDto userDto = new UserDto();

		LocalDate birthDate = LocalDate.of(1987, 11, 19);

		userDto.setName("Angie");
		userDto.setBirthDate(birthDate);

		Optional<UserDto> userResponse = this.userServiceImpl.createUser(userDto);

		String actualName = userDto.getName();
		String expectedName = userResponse.get().getName();

		assertThat(actualName).isEqualTo(expectedName);
	}
	
	@Test
	public void updateUser() {

		UserDto userDto = new UserDto();

		LocalDate birthDate = LocalDate.of(1987, 04, 28);

		userDto.setId(1);
		userDto.setName("Robin");
		userDto.setBirthDate(birthDate);

		Optional<UserDto> userResponse = this.userServiceImpl.updateUser(userDto);

		String actualName = userDto.getBirthDate().toString();
		String expectedName = userResponse.get().getBirthDate().toString();

		assertThat(actualName).isEqualTo(expectedName);
	}
	
}
