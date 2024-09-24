package com.example.Car_Rental_Spring.Service.auth;


import com.example.Car_Rental_Spring.DTO.SignupRequest;
import com.example.Car_Rental_Spring.DTO.UserDto;
import com.example.Car_Rental_Spring.Entity.User;
import com.example.Car_Rental_Spring.Enums.UserRole;
import com.example.Car_Rental_Spring.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class authServiceImpl implements authService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByUserRole(UserRole.Admin);
        if (adminAccount == null){
            User newAdminAccount = new User();
            newAdminAccount.setName("Admin");
            newAdminAccount.setEmail("musfir@admin.com"); // Change this to your new email
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("musfir")); // Change this to your new password
            newAdminAccount.setUserRole(UserRole.Admin);
            userRepository.save(newAdminAccount);
            System.out.println("Admin account created successfully");
        } else {
            adminAccount.setEmail("musfir@admin.com"); // Change this to your new email
            adminAccount.setPassword(new BCryptPasswordEncoder().encode("musfir")); // Change this to your new password
            userRepository.save(adminAccount);
            System.out.println("Admin account updated successfully");
        }
    }



    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user =new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.Student);

        User createUser = userRepository.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(createUser.getId());
        userDto.setName(createUser.getName());
        userDto.setEmail(createUser.getEmail());
        userDto.setUserrole(createUser.getUserRole());



        return userDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}