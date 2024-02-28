package com.asherflo.CgpaProject.controller;

import com.asherflo.CgpaProject.dto.request.StudentRequestDto;
import com.asherflo.CgpaProject.dto.request.UpdateStudentDto;
import com.asherflo.CgpaProject.dto.response.StudentDto;
import com.asherflo.CgpaProject.model.Student;
import com.asherflo.CgpaProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody StudentRequestDto studentRequestDto){
        StudentDto studentDto= studentService.registerStudent(studentRequestDto);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public   ResponseEntity<?> updatedProfile(@RequestBody UpdateStudentDto updateStudentDto, @PathVariable Long id){
        UpdateStudentDto updateStudent = studentService.updateStudentProfile(updateStudentDto, id);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }


    @GetMapping("/getdropoutstudents")
    public ResponseEntity<?> getDropOutStudent(){
        List<Student> getDroppedStudent = studentService.getDropOutRate();
        return new ResponseEntity<>(getDroppedStudent,HttpStatus.OK);
    }
    @GetMapping("/students")
    public  ResponseEntity<?> getAllStudent(){
        List<Student> getAllStudent = studentService.getAllStudent();
        return new ResponseEntity<>(getAllStudent,HttpStatus.OK);

    }



}
