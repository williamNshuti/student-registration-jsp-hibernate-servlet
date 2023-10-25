package com.pack.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student_semester_registration")
public class StudentRegistrationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentDetailsModel student;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id")
    private AcademicUnit academicUnit;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private SemesterModel semester;

    @Column(name = "registration_date")
    private LocalDate registrationDate;
    
    

    @OneToMany(mappedBy = "registrations")
    private List<StudentDetailsModel> students;

    @OneToMany(mappedBy = "registrations")
    private List<SemesterModel> semesters;
    
    @OneToMany(mappedBy = "studentRegistration")
    private List<StudentCourseRegistration> courseRegistrations;
    
    
    
    @Column(name = "total_credits")
    private Integer totalCredits; // Use Integer wrapper type


    // Constructors, getters, and setters

    public StudentRegistrationModel() {
    	this.totalCredits = 0;
    }

    public StudentRegistrationModel(AcademicUnit academicUnit, SemesterModel semester, StudentDetailsModel student, LocalDate registrationDate ) {
        this.academicUnit = academicUnit;
        this.semester = semester;
        this.student = student;
        this.registrationDate = registrationDate;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for academicUnit
    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    // Getter and Setter for semester
    public SemesterModel getSemester() {
        return semester;
    }

    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }

    // Getter and Setter for student
    public StudentDetailsModel getStudent() {
        return student;
    }

    public void setStudent(StudentDetailsModel student) {
        this.student = student;
    }

    // Getter and Setter for registrationDate
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Getter and Setter for students
    public List<StudentDetailsModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDetailsModel> students) {
        this.students = students;
    }

    // Getter and Setter for semesters
    public List<SemesterModel> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterModel> semesters) {
        this.semesters = semesters;
    }
    
    public Integer getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }
    
    
}
