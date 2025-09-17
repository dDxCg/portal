package io.edu.user.mapper;

import org.mapstruct.Mapper;

import io.edu.user.dto.TeacherDTO;

@Mapper (componentModel = "spring")
public interface TeacherMapper {
    TeacherDTO toDto(TeacherDTO teacher);
    TeacherDTO toEntity(TeacherDTO teacherDTO);
}
