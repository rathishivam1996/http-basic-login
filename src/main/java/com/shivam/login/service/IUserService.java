package com.shivam.login.service;

import com.shivam.login.model.JpaUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IUserService {
    JpaUser saveUser(JpaUser user);

    Optional<JpaUser> findById(String uuid);

    Optional<JpaUser> findByEmail(String email);

    JpaUser updatePasswordById(String uuid, String password);

    void deleteByUuid(String uuid);
}
