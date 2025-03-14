package com.example.ajopay.repository;

import com.example.ajopay.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
 Optional<Users> findByFirstName(String firstName);
 Optional<Users> findByAccountNumber(String accountNumber);


 // Users findByUsername(String FirstName);
Optional<Users> findByEmail(String email);

Boolean existsByEmail(String email);
}
