package com.pack.dao;

import com.pack.model.TeacherModel;

import java.util.List;

public interface TeacherDao {

    // Insert a new teacher record
    void insertTeacher(TeacherModel teacher);

    // Retrieve a teacher record by ID
    TeacherModel selectTeacher(int teacherId);

    // Retrieve all teacher records
    List<TeacherModel> selectAllTeachers();

    // Delete a teacher record by ID
    boolean deleteTeacher(int id);

    // Update a teacher record
    void updateTeacher(TeacherModel teacher);
}
