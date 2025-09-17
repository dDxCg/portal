package io.edu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.edu.user.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(String studentId);
}
