package com.bookpack.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import com.bookpack.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
