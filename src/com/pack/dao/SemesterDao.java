package com.pack.dao;

import java.util.List;

import com.pack.model.SemesterModel;
import com.pack.model.StudentRegistrationModel;

public interface SemesterDao {
	
	 // Insert a new student record
    void insertSemester(SemesterModel semester);

    // Retrieve a student record by ID
    SemesterModel selectSemester(int semesterId);

    // Retrieve all student records
    List<SemesterModel> selectAllSemesters();

    // Delete a student record by ID
    boolean deleteSemester(int id);

    // Update a student record
    void updateSemester(SemesterModel semester);
    
    List<StudentRegistrationModel> getStudentsRegisteredInSemester(SemesterModel semester);

    


}
