package com.elotech.library_management.repository;

import com.elotech.library_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
