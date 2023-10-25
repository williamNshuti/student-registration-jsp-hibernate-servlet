package com.pack.dao;

import com.pack.model.StudentDetailsModel;

import java.util.List;

public interface StudentDetailsDao {

    // Insert a new student record
    void insertStudent(StudentDetailsModel student);

    // Retrieve a student record by ID
    StudentDetailsModel selectStudent(int studentId);

    // Retrieve all student records
    List<StudentDetailsModel> selectAllStudents();

    // Delete a student record by ID
    boolean deleteStudent(int id);

    // Update a student record
    void updateStudent(StudentDetailsModel student);
}
