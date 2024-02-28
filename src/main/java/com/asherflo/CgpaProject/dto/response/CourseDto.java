package com.asherflo.CgpaProject.dto.response;

import com.asherflo.CgpaProject.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

        private String message;
        private Course course;

}
