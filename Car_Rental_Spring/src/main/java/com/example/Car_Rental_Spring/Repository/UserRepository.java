package com.example.Car_Rental_Spring.Repository;

import com.example.Car_Rental_Spring.Entity.User;
import com.example.Car_Rental_Spring.Enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
