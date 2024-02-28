package com.asherflo.CgpaProject.dto.request;

import com.asherflo.CgpaProject.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentDto {
    private String address;
    private Status status;
}
