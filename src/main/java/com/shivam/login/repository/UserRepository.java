package com.shivam.login.repository;

import com.shivam.login.model.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<JpaUser, String>, JpaSpecificationExecutor<JpaUser> {
    //	public JpaUser findByUsername();
}
