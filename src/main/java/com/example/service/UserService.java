package com.example.service;

import com.example.exception.UserAlreadyExistsException;
import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public String addGroceryUser(User user) throws UserAlreadyExistsException;
    public String addAdminUser(User user);
    public boolean AuthenticateUser(User user);

    public User getUserByEmail(String email);

}
