package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")
public class User {
   @Id
   private String userId;
   private String userRole;
   private String userFirstName;
   private String userLastName;
   private String userEmail;
   private String userMobileNumber;

   public User() {
   }

   public User(String userId, String userRole, String userFirstName, String userLastName, String userEmail, String userMobileNumber) {
      this.userId = userId;
      this.userRole = userRole;
      this.userFirstName = userFirstName;
      this.userLastName = userLastName;
      this.userEmail = userEmail;
      this.userMobileNumber = userMobileNumber;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getUserRole() {
      return userRole;
   }

   public void setUserRole(String userRole) {
      this.userRole = userRole;
   }

   public String getUserFirstName() {
      return userFirstName;
   }

   public void setUserFirstName(String userFirstName) {
      this.userFirstName = userFirstName;
   }

   public String getUserLastName() {
      return userLastName;
   }

   public void setUserLastName(String userLastName) {
      this.userLastName = userLastName;
   }

   public String getUserEmail() {
      return userEmail;
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   public String getUserMobileNumber() {
      return userMobileNumber;
   }

   public void setUserMobileNumber(String userMobileNumber) {
      this.userMobileNumber = userMobileNumber;
   }
}
