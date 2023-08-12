package com.shivam.login.repository;

import com.shivam.login.model.Authority;
import com.shivam.login.model.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorityRepository extends JpaRepository<Authority, String>, JpaSpecificationExecutor<JpaUser> {
}
