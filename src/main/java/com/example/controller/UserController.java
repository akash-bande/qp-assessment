package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.example.service.impl.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/admin/adduser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addUserByAdmin(@RequestBody @Valid User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userService.addGroceryUser(user);
    return "User added succesfully By admin";
    }

    @PostMapping("/admin/addadminuser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addAdminUserByAdmin(@RequestBody @Valid User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addAdminUser(user);
        return "Admin User added succesfully..!";
    }

    @PostMapping("/admin/login")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminUserLogin(@RequestBody @Valid User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addGroceryUser(user);
        return "Signup successfully done..!";
    }

    @PostMapping("/user/signup")
    public String addUser(@RequestBody @Valid User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addGroceryUser(user);
        return "Signup successfully done..!";
    }

    @PostMapping("/user/login")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('GROCERY_USER')")
    public String groceryUserLogin(@RequestBody @Valid User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addGroceryUser(user);
        return "Signup successfully done..!";
    }

    public User getLoggedInUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!= null && authentication.getPrincipal() instanceof UserDetails){
            UserDetails currentUser = (UserDetails) authentication.getPrincipal();
            User user=userService.getUserByEmail(currentUser.getUsername());
            if(user!=null)
                return user;
            else
                throw new UsernameNotFoundException("User does not exists with Email: "+currentUser.getUsername());
        }
        return null;
    }


}
