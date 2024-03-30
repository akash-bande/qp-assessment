package com.example.controller;

import com.example.exception.UserAlreadyExistsException;
import com.example.model.User;
import com.example.service.UserService;
import com.example.service.impl.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/admin/adduser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addUserByAdmin(@RequestBody @Valid User user) throws UserAlreadyExistsException {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userService.addGroceryUser(user);
    return "User added succesfully By admin";
    }

    @PostMapping("/admin/addadminuser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addAdminUserByAdmin(@RequestBody @Valid User user){
        User alreadyloggedinUser = getLoggedInUserInfo();
        if(alreadyloggedinUser==null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserEmail(), user.getPassword()));
            System.out.println(authentication.getDetails());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "User logged-in successfully..!";
        }
        else {
            return "User : "+alreadyloggedinUser.getUserFirstName()+"Already logged in";
        }
    }

    @PostMapping("/admin/login")
    public String adminUserLogin(@RequestBody @Valid User user) throws UserAlreadyExistsException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addGroceryUser(user);
        return "Signup successfully done..!";
    }

    @PostMapping("/user/signup")
    public String addUser(@RequestBody @Valid User user) throws UserAlreadyExistsException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addGroceryUser(user);
        return "Signup successfully done..!";
    }

    @PostMapping("/user/login")
    public String groceryUserLogin(@RequestBody @Valid User user) {
        User alreadyloggedinUser = getLoggedInUserInfo();
        System.out.println("already logged user" +alreadyloggedinUser);
        if(alreadyloggedinUser==null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserEmail(), user.getPassword()));
            System.out.println(authentication.isAuthenticated());
            System.out.println("Pricipal : "+((UserDetails)authentication.getPrincipal()).getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "User logged-in successfully!.";
        }
        else {
            return "User : "+alreadyloggedinUser.getUserFirstName()+"Already logged in";
        }
    }

    @GetMapping("/user/getmyinfo")
    //@PreAuthorize("hasAuthority('GROCERY_USER') or hasAuthority('ADMIN')")
    public User getLoggedInUserInfo(){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("User details "+authentication.getPrincipal());
            System.out.println(authentication.isAuthenticated());
            if(authentication!= null && authentication.getPrincipal() instanceof UserDetails){
                UserDetails currentUser = (UserDetails) authentication.getPrincipal();
                User user=userService.getUserByEmail(currentUser.getUsername());
                System.out.println(user);
                if(user!=null)
                    return user;
                else
                    throw new UsernameNotFoundException("User does not exists with Email: "+currentUser.getUsername());
            }
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return null;
    }


}
