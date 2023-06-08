package com.shivam.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shivam.login.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
