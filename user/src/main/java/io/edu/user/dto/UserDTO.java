package io.edu.user.dto;

import io.edu.user.model.UserStatus;

public class UserDTO {
    private Long id;
    private String email;
    private String role;
    private UserStatus status;

    // Constructors
    public UserDTO() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public UserStatus getStatus() { return status; }
    public void setStatus(UserStatus status) { this.status = status; }
}
