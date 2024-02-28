package com.asherflo.CgpaProject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String studentName;
    private Year admissionYear;
    private  String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private  Status status;
}
