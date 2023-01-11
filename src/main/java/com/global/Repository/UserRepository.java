package com.global.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findUserByEmail(String email);
}
