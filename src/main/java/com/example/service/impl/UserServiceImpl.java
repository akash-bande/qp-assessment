package com.example.service.impl;

import com.example.constants.ApplicationConstants;
import com.example.exception.UserAlreadyExistsException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        loadUsers();
    }

    @Override
    public String addGroceryUser(User user) throws UserAlreadyExistsException {
        user.setUserRole(ApplicationConstants.ROLE_GROCERY_USER);
        User newUser = userRepository.save(user);
        if(newUser!=null)
            return "User successfully Added..!";
        else
            throw new UserAlreadyExistsException("User already exists with email: "+user.getUserEmail());
    }

    @Override
    public String addAdminUser(User user) {
        user.setUserRole(ApplicationConstants.ROLE_ADMIN);
        userRepository.save(user);
        return "Admin user successfully Added..!";

    }

    @Override
    public boolean AuthenticateUser(User user) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByUserEmail(email);
        if (!user.isEmpty())
        {
            return user.get();
        }
        else{
            return null;
        }
    }

    private void loadUsers(){
        User adminUser = new User(1,"ADMIN","admin","","admin@grocery.com","9822112233",passwordEncoder.encode("admin"));
        User groceryUser = new User(2,"GROCERY_USER","Akash","B","akash@gmail.com","9822122233",passwordEncoder.encode("akash123"));
        userRepository.save(adminUser);
        userRepository.save(groceryUser);
    }
}
