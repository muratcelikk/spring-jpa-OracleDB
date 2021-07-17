package com.cal.pro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cal.pro.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
