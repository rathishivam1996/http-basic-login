package com.shivam.login.repository;

import com.shivam.login.model.JpaUser;
import com.shivam.login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role, String>, JpaSpecificationExecutor<JpaUser> {

}
