//package com.asherflo.CgpaProject.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
//public class StudentCourse {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    private Student student;
//
//    private Course course;
//    private  String grade;
//    private Semester semester;
//    private  String score;
//}
