package com.asherflo.CgpaProject.controller;

import com.asherflo.CgpaProject.dto.request.CourseRequestDto;
import com.asherflo.CgpaProject.dto.request.UpdateCourseRequestDto;
import com.asherflo.CgpaProject.dto.response.CourseDto;
import com.asherflo.CgpaProject.dto.response.UpdateCourseDto;
import com.asherflo.CgpaProject.model.Course;
import com.asherflo.CgpaProject.service.CGPACalculator;
import com.asherflo.CgpaProject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/course")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    private CGPACalculator cgpaCalculator;

    @PostMapping("/register")
    public ResponseEntity<?> registerCourse(@RequestBody CourseRequestDto courseRequestDto) {
        CourseDto courseDto = courseService.registerCourse(courseRequestDto);
        return new ResponseEntity<>(courseDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatedCourse(@RequestBody UpdateCourseRequestDto updateCourseRequestDto, @PathVariable Long id) {
        UpdateCourseDto updateCourse = courseService.updateCourse(updateCourseRequestDto, id);
        return new ResponseEntity<>(updateCourse, HttpStatus.OK);

    }


    @GetMapping("/courses")
    public  ResponseEntity<?> getAllCourses() {
        List<Course> getAllCourse = courseService.getAllCourse();
        return new ResponseEntity<>(getAllCourse, HttpStatus.OK);
    }
  @GetMapping("/courses/{id}")
  public ResponseEntity<?> getCourseByIid (@PathVariable("id") Long id) {
        Optional<Course> course = courseService.findById(id);
                return new ResponseEntity<>(course, HttpStatus.OK);}


    @GetMapping("/{id}/cgpa")
    public ResponseEntity<Double> calculateStudentCGPA(@PathVariable Long id) {
        double cgpa = cgpaCalculator.calculateCGPA(id);
        return ResponseEntity.ok(cgpa);
    }

}