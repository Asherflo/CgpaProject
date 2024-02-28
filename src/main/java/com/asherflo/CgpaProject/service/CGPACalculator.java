package com.asherflo.CgpaProject.service;


import com.asherflo.CgpaProject.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CGPACalculator {
    @Autowired
    private  CourseService courseService;

    public double calculateCGPA(Long studentId) {
        List<Course> courses = courseService.findByStudentId(studentId);
        double totalGradePoints = 0;
        int totalCreditScores = 0;

        for (Course course : courses) {
            totalGradePoints += calculateGradePoints(course.getGrade(), course.getCreditScore());
            totalCreditScores += course.getCreditScore();
        }

        if (totalCreditScores == 0) {
            // Handle division by zero
            return 0.0;
        }

        return totalGradePoints / totalCreditScores;
    }

    private double calculateGradePoints(String grade, int creditScore) {
        // Assign grade point values based on the grading system
        double gradePoint = switch (grade) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default -> 0.0;
        };
        return gradePoint * creditScore;
    }
}

