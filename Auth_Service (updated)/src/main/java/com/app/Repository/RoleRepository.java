package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
