package io.edu.user.dto;

import io.edu.user.model.UserStatus;

public class UserUpdateDTO {
    private String email;
    private String role;
    private UserStatus status;

    // Constructors
    public UserUpdateDTO() {}

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public UserStatus getStatus() { return status; }
    public void setStatus(UserStatus status) { this.status = status; }
}
