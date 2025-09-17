package io.edu.user.dto;

public class ChangePassDTO {
    private String oldPassword;
    private String newPassword;

    // Constructors
    public ChangePassDTO() {}
    public ChangePassDTO(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    // Getters and Setters
    public String getOldPassword() { return oldPassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }
    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}
