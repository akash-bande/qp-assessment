package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Entity
@Table(name="user_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "user_id")
   private long userId;
   private String userRole;//ADMIN,GROCERY_USER
   @NotNull(message = "user first name should not be blank")
   private String userFirstName;
   private String userLastName;
   @Email(message = "Email address is not valid")
   @Column(unique = true)
   @NotNull(message = "user email should not be blank")
   private String userEmail;
   @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile number is not valid")
   private String userMobileNumber;
   @NotNull(message = "user password name should not be blank")
   private String password;
}
