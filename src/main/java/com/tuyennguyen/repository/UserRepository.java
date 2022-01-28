package com.tuyennguyen.repository;

import com.tuyennguyen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    public int countUserByUsernameOrEmail(String username, String email);

}
