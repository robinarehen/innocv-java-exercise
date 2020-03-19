package com.innocv.test.exercise.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(nullable = false, length = 50)
	@NonNull
	String name;
	
	@Column(name = "birth_date", nullable = false)
	@NonNull
	LocalDate birthDate;

	@Column(name = "create_date")
	LocalDateTime createDate;
	
	@PrePersist
	@PreUpdate
	public void prePersis() {
		this.createDate = LocalDateTime.now();
	}

}
