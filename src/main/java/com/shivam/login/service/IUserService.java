package com.shivam.login.service;

import com.shivam.login.model.JpaUser;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {
    JpaUser saveUser(JpaUser user);

    Iterable<JpaUser> saveAll(Iterable<JpaUser> users);

    Optional<JpaUser> findById(String uuid);

    Optional<JpaUser> findByUsername(String username);

    List<JpaUser> findByUsernameLike(String username);

    List<JpaUser> findByCreatedAtBetween(Instant from, Instant to);

    List<JpaUser> findByUpdatedAtBetween(Instant from, Instant to);

    JpaUser updateUserById(String uuid, JpaUser user);

    JpaUser updateUserByUsername(String username, JpaUser user);

    List<JpaUser> findAll();

    void deleteById(String uuid);

    void deleteByUsername(String username);

    void deleteAll();
}
