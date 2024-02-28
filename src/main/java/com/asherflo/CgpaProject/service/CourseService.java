package com.asherflo.CgpaProject.service;

import com.asherflo.CgpaProject.dto.request.CourseRequestDto;
import com.asherflo.CgpaProject.dto.request.UpdateCourseRequestDto;
import com.asherflo.CgpaProject.dto.response.UpdateCourseDto;
import com.asherflo.CgpaProject.dto.response.CourseDto;
import com.asherflo.CgpaProject.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDto registerCourse(CourseRequestDto courseRequestDto);
    List<Course> getAllCourse();
    UpdateCourseDto updateCourse(UpdateCourseRequestDto updateCourseRequestDto, Long id);
    Optional<Course> findById(Long id);

    List<Course> findByStudentId(Long studentId);
}
