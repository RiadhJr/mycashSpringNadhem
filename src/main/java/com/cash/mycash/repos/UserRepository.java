package com.cash.mycash.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cash.mycash.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername (String username);
}
