package com.example.service.impl;

import com.example.constants.ApplicationConstants;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        loadUsers();
    }

    @Override
    public String addGroceryUser(User user) {
        user.setUserRole(ApplicationConstants.ROLE_GROCERY_USER);
        userRepository.save(user);
        return "User successfully Added..!";
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
        User adminUser = new User(1,"ADMIN","admin","","admin@grocery.com","9822112233","admin");
        User groceryUser = new User(2,"GROCERY_USER","Akash","B","akash@gmail.com","9822122233","akash123");
        userRepository.save(adminUser);
        userRepository.save(groceryUser);
    }
}
