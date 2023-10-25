package com.pack.dao;

import com.pack.model.CourseDefinitionModel;

import java.util.List;

public interface CourseDefinitionDao {

    // Insert a new course definition record
    void insertCourseDefinition(CourseDefinitionModel courseDefinition);

    // Retrieve a course definition record by ID
    CourseDefinitionModel selectCourseDefinition(int courseDefinitionId);

    // Retrieve all course definition records
    List<CourseDefinitionModel> selectAllCourseDefinitions();

    // Delete a course definition record by ID
    boolean deleteCourseDefinition(int id);

    // Update a course definition record
    void updateCourseDefinition(CourseDefinitionModel courseDefinition);
}
