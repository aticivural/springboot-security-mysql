package com.vural.security.springbootsecuritymysql.repository;

import com.vural.security.springbootsecuritymysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByName(String username);
}
