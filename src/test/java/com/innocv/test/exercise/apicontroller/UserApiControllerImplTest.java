package com.innocv.test.exercise.apicontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innocv.test.exercise.dto.UserDto;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiControllerImplTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	private MvcResult mvcResult;

	@Test
	public void getAllUsers() throws Exception {
		String uri = "/user";
		
		this.mvcResult = this.mockMvc.perform(
				get(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();

		Integer responseStatus = this.mvcResult.getResponse().getStatus();

		Integer expected = 200;
		assertThat(responseStatus).isEqualTo(expected);
	}

	@Test
	public void createUser() throws Exception {
		String uri = "/user";

		UserDto userDto = new UserDto();
		userDto.setName("Daniela");
		userDto.setBirthDate(LocalDate.of(2000, 04, 20));

		this.mvcResult = this.mockMvc.perform(
				post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.objectMapper.writeValueAsBytes(userDto))
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();

		Integer expectedActual = 201;
		Integer statusActual = this.mvcResult.getResponse().getStatus();

		assertThat(statusActual).isEqualTo(expectedActual);
	}
}
