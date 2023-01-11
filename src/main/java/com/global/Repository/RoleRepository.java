package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	
}
