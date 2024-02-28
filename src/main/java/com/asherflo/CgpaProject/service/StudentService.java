package com.asherflo.CgpaProject.service;

import com.asherflo.CgpaProject.dto.request.StudentRequestDto;
import com.asherflo.CgpaProject.dto.request.UpdateStudentDto;
import com.asherflo.CgpaProject.dto.response.StudentDto;
import com.asherflo.CgpaProject.model.Student;

import java.util.List;

public interface StudentService {
    StudentDto registerStudent(StudentRequestDto studentRequestDto);

    UpdateStudentDto  updateStudentProfile(UpdateStudentDto updateStudentDto, Long id);
    List<Student> getAllStudent();
    List<Student> getDropOutRate();




}
