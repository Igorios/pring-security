package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.role.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
