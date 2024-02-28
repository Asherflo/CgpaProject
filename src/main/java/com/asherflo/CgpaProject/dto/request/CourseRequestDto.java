package com.asherflo.CgpaProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class CourseRequestDto {
        private String courseCode;
        private String courseName;
        private String grade;
        private int creditScore;


}
