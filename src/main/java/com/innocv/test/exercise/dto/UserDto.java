package com.innocv.test.exercise.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDto {

	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private LocalDate birthDate;
	private LocalDateTime createDate;
}
