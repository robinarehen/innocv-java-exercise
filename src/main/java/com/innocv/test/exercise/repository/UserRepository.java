package com.innocv.test.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innocv.test.exercise.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
