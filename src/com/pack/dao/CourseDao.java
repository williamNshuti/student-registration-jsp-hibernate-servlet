package com.pack.dao;

import java.util.List;

import com.pack.model.AcademicUnit;
import com.pack.model.CourseModel;

public interface CourseDao {
	
	 // Create a new course
    void createCourse(CourseModel course);

    // Read a course by ID
    CourseModel getCourseById(int id);

    // Read all courses
    List<CourseModel> getAllCourses();

    // Update a course
    void updateCourse(CourseModel course);

    // Delete a course
    boolean deleteCourse(int id);
    
    List<CourseModel> getCoursesByAcademicUnit(AcademicUnit academicUnit);


}
