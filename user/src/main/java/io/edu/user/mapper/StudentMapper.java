package io.edu.user.mapper;

import org.mapstruct.Mapper;

import io.edu.user.dto.StudentDTO;

@Mapper (componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDto(StudentDTO student);
    StudentDTO toEntity(StudentDTO studentDTO);
}