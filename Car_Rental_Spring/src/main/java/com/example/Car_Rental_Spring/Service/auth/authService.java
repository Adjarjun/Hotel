package com.example.Car_Rental_Spring.Service.auth;

import com.example.Car_Rental_Spring.DTO.SignupRequest;
import com.example.Car_Rental_Spring.DTO.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface authService {

    static UserDetails loadUserByUsername(String username) {
        return null;
    }

    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);
}
