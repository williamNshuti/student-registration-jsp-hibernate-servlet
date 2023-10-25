package com.pack.model;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_registration_id")
    private StudentRegistrationModel studentRegistration;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    // Default no-argument constructor
    public StudentCourseRegistration() {
    }

    // Constructor with all fields
    public StudentCourseRegistration( StudentRegistrationModel studentRegistration, CourseModel course) {
        this.studentRegistration = studentRegistration;
        this.course = course;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentRegistrationModel getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistrationModel studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    // Add getters and setters for other fields as needed
}
