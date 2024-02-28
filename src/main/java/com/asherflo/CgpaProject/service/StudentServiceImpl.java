package com.asherflo.CgpaProject.service;

import com.asherflo.CgpaProject.dto.request.StudentRequestDto;
import com.asherflo.CgpaProject.dto.request.UpdateStudentDto;
import com.asherflo.CgpaProject.dto.response.StudentDto;
import com.asherflo.CgpaProject.exception.StudentException;
import com.asherflo.CgpaProject.model.Status;
import com.asherflo.CgpaProject.model.Student;
import com.asherflo.CgpaProject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    @Autowired
    private ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    @Override
    public StudentDto registerStudent(StudentRequestDto studentRequestDto) {
        Student student =  Student.builder()
                .id(studentRequestDto.getStudentId())
                .studentName(studentRequestDto.getStudentName())
                .address(studentRequestDto.getAddress())
                .email(studentRequestDto.getEmail())
                .admissionYear(studentRequestDto.getAdmissionYear())
                .status(studentRequestDto.getStatus())
                .build();
        Student registeredStudent = studentRepository.save(student);
        StudentDto studentDto = new StudentDto();
        studentDto.setMessage("registration successfully!!, welcome to chemistry department");
        studentDto.setStudent(registeredStudent);
        return studentDto ;
    }


    @Override
    public UpdateStudentDto  updateStudentProfile(UpdateStudentDto updateStudentDto, Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentException("student doesn't exist", 404));
        Student saved = modelMapper.map(updateStudentDto, Student.class);
        student.setAddress(updateStudentDto.getAddress());
        student.setStatus(updateStudentDto.getStatus());
        studentRepository.save(student);
       return modelMapper.map(saved, UpdateStudentDto.class);



    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getDropOutRate() {
        return studentRepository.findByStatus(Status.INACTIVE);
//        List<Student> getStudentByDropOutRate = new ArrayList<>();
//        getStudentByDropOutRate.add(student);
//
//        return getStudentByDropOutRate;


    }

}
