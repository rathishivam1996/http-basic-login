package com.shivam.login.service.admin;

import com.shivam.login.model.JpaUser;

import java.time.Instant;
import java.util.List;

public interface IAdminService {

    Iterable<JpaUser> saveAllUser(Iterable<JpaUser> users);

    List<JpaUser> findByEmailLike(String email);

    List<JpaUser> findByCreatedAtBetween(Instant from, Instant to);

    List<JpaUser> findByUpdatedAtBetween(Instant from, Instant to);

    List<JpaUser> findAll();

    void deleteAll();
}
