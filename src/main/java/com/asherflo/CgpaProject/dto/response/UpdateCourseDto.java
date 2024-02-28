package com.asherflo.CgpaProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCourseDto {
    private String courseCode;
    private String courseName;

}
