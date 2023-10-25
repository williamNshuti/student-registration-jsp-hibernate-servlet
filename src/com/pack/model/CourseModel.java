package com.pack.model;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class CourseModel {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private int id;

	 @OneToOne
	 @JoinColumn(name = "course_definition_id")
	 private CourseDefinitionModel courseDefinition;
	 
	 @ManyToOne
	 @JoinColumn(name = "academic_unit_id")
	 private AcademicUnit academicUnit;
	 
	 @OneToOne
	 @JoinColumn(name = "teacher_id")
	 private TeacherModel teacher; 

	@ManyToOne
	@JoinColumn(name = "semester_id")
	private SemesterModel semester;
	
	 @Column(name = "course_credit")
	 private int credit;
	 
	 @OneToMany(mappedBy = "course")
	 private List<StudentCourseRegistration> studentRegistrations;

	 
	 
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }
    public int getCredit() {
        return credit;
    }

    // Setter for id
    public void setCredit(int credit) {
        this.credit = credit;
    }

    // Getter for courseDefinition
    public CourseDefinitionModel getCourseDefinition() {
        return courseDefinition;
    }

    // Setter for courseDefinition
    public void setCourseDefinition(CourseDefinitionModel courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    // Getter for academicUnit
    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    // Setter for academicUnit
    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    // Getter for teacher
    public TeacherModel getTeacher() {
        return teacher;
    }

    // Setter for teacher
    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    // Getter for semester
    public SemesterModel getSemester() {
        return semester;
    }

    // Setter for semester
    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }
    
    public List<StudentCourseRegistration> getStudentRegistrations() {
        return studentRegistrations;
    }

    // Setter for studentRegistrations
    public void setStudentRegistrations(List<StudentCourseRegistration> studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }
    
    public CourseModel() {
        // Default constructor
    }

    public CourseModel(
        CourseDefinitionModel courseDefinition,
        AcademicUnit academicUnit,
        TeacherModel teacher,
        SemesterModel semester,
        int credit
      
    ) {
        this.courseDefinition = courseDefinition;
        this.academicUnit = academicUnit;
        this.teacher = teacher;
        this.semester = semester;
        this.credit =credit;
       
    }

}
