package com.asherflo.CgpaProject.dto.request;

import com.asherflo.CgpaProject.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    private  Long studentId;
    private String studentName;
    private Year admissionYear;
    private  String email;
    private String address;
    private Status status;

}
