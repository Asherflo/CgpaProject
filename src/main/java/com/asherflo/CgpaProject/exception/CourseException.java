package com.asherflo.CgpaProject.exception;

public class CourseException extends RuntimeException{
    private final int statusCode;
    public CourseException(String message, int statusCode) {
        super(message);
        this.statusCode= statusCode;
    }
}
