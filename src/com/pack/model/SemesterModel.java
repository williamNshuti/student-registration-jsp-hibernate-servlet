package com.pack.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Semester")
public class SemesterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
    
    @OneToMany(mappedBy = "semester")
    private List<StudentRegistrationModel> registrations;

    // Constructors, getters, and setters

    public SemesterModel() {
    }

    public SemesterModel(int id, String name, LocalDate startDate, LocalDate endDate) {
    	this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for startDate (LocalDate)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getter and Setter for endDate (LocalDate)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public List<StudentRegistrationModel> getRegistrations() {
        return registrations;
    }
    
    public void setRegistrations(List<StudentRegistrationModel> registrations) {
        this.registrations = registrations;
    }


}
