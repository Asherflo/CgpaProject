package com.asherflo.CgpaProject.repository;

import com.asherflo.CgpaProject.model.Status;
import com.asherflo.CgpaProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByStatus(Status status);
}
