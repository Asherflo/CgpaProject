package com.asherflo.CgpaProject.service;

import com.asherflo.CgpaProject.dto.request.*;
import com.asherflo.CgpaProject.dto.response.CourseDto;
import com.asherflo.CgpaProject.dto.response.UpdateCourseDto;
import com.asherflo.CgpaProject.exception.CourseException;
import com.asherflo.CgpaProject.model.Course;
import com.asherflo.CgpaProject.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements  CourseService{

    private final CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;

        @Override
//        public CourseDto registerCourse(CourseRequestDto courseRequestDto, ModelMapper modelMapper) {
//                Course course = modelMapper.map(courseRequestDto,Course.class);
//
//                        Course.builder()
//                        .courseCode(courseRequestDto.getCourseCode())
//                        .courseName(courseRequestDto.getCourseName())
//                        .grade(courseRequestDto.getGrade())
//                        .creditScore(courseRequestDto.getCreditScore())
//                        .build();
//                Course savedCourse = courseRepository.save(course);
//                CourseDto courseDto = new CourseDto();
//                courseDto.setMessage("registration successfully!!");
//                courseDto.setCourse(savedCourse);
//                return courseDto;
//            }

    public CourseDto registerCourse(CourseRequestDto courseRequestDto) {
        // Use ModelMapper to map CourseRequestDto to Course
        Course course = modelMapper.map(courseRequestDto, Course.class);

        // Save the mapped Course object
        Course savedCourse = courseRepository.save(course);

        // Prepare the response
        CourseDto courseDto = new CourseDto();
        courseDto.setMessage("Registration successful!!");
        courseDto.setCourse(savedCourse);

        return courseDto;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public UpdateCourseDto updateCourse(UpdateCourseRequestDto updateCourseRequestDto, Long id) {
        Course course = courseRepository.findById(id).orElseThrow(()-> new CourseException("Course doesn't exist", 404));
        Course saved = modelMapper.map(updateCourseRequestDto,Course.class);
        course.setCourseCode(updateCourseRequestDto.getCourseCode());
        course.setCourseName(updateCourseRequestDto.getCourseName());
        courseRepository.save(course);
        return modelMapper.map(saved,UpdateCourseDto.class);



    }

    @Override
    public Optional<Course> findById(Long id) {
            return courseRepository.findById(id);
    }

    @Override
    public List<Course> findByStudentId(Long studentId) {
        return courseRepository.findByStudentId(studentId);
    }


}
