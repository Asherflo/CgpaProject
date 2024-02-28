package com.asherflo.CgpaProject.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String courseName;
    private String grade;
    private int creditScore;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
