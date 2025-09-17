package io.edu.user.dto;

import java.time.LocalDate;

public class StudentDTO {
    private String studentId;
    private String firstName;
    private String lastName;
    private String major;
    private LocalDate enrollmentDate;
    private LocalDate expectedGraduation;
    private LocalDate dob; 

    // Constructors, getters, setters
    public StudentDTO() {}

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public LocalDate getExpectedGraduation() {
        return expectedGraduation;
    }
    public void setExpectedGraduation(LocalDate expectedGraduation) {
        this.expectedGraduation = expectedGraduation;
    }
}

