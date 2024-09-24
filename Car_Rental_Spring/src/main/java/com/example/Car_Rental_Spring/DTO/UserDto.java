package com.example.Car_Rental_Spring.DTO;


import com.example.Car_Rental_Spring.Enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String name;

    private String email;


    private UserRole userrole;

}
