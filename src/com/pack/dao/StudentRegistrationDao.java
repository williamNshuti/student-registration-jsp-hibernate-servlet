package com.pack.dao;

import java.util.List;

import com.pack.model.AcademicUnit;
import com.pack.model.SemesterModel;
import com.pack.model.StudentDetailsModel;
import com.pack.model.StudentRegistrationModel;

public interface StudentRegistrationDao {
	
	 // Create a new course
    void save(StudentRegistrationModel studentRegistration);

    // Read a course by ID
    StudentRegistrationModel getById(int id);

    // Read all courses
    List<StudentRegistrationModel> getAll();

    // Update a course
    void update(StudentRegistrationModel studentRegistration);

    // Delete a course
    boolean delete(int id);
    
    List<StudentDetailsModel> getStudentsByDepartmentAndSemester(AcademicUnit department, SemesterModel semester);

    


}
