package com.asherflo.CgpaProject.dto.response;

import com.asherflo.CgpaProject.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String message;
    private Student student;

}
