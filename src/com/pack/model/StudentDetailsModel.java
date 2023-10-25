package com.pack.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class StudentDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reg_no", unique = true)
    private String regNo;

    @Column(name = "names")
    private String names;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @OneToMany(mappedBy = "student")
    private List<StudentRegistrationModel> registrations;

    public StudentDetailsModel() {
    }
    
   

    public StudentDetailsModel(int id, String regNo, String names, LocalDate dateOfBirth) {
        this.id = id;
        this.regNo = regNo;
        this.names = names;
        this.dateOfBirth = dateOfBirth;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for regNo
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    // Getter and Setter for names
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    // Getter and Setter for dateOfBirth (LocalDate)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public List<StudentRegistrationModel> getRegistrations() {
        return registrations;
    }
    
    public void setRegistrations(List<StudentRegistrationModel> registrations) {
        this.registrations = registrations;
    }


}
