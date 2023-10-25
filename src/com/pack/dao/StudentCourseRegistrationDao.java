package com.pack.dao;

import java.util.List;

import com.pack.model.StudentCourseRegistration;

public interface StudentCourseRegistrationDao {
	
    StudentCourseRegistration getById(int id);

    void save(StudentCourseRegistration studentCourseRegistration);

    void update(StudentCourseRegistration studentCourseRegistration);

    boolean delete(int id);
    
    List<StudentCourseRegistration> getAllByStudentRegistrationId(int studentRegistrationId);


}
