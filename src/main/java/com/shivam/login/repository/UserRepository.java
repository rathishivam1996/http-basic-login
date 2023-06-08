package com.shivam.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.login.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
