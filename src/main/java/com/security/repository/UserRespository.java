package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.model.User;

public interface UserRespository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);

}
