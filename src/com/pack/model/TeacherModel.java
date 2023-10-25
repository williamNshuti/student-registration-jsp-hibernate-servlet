package com.pack.model;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class TeacherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "fullname")
    private String fullname;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualification")
    private Qualification qualification;

    public enum Qualification {
        MASTERS,
        PHD,
        PROFESSOR
    }

    public TeacherModel() {
    }

    public TeacherModel(int id, String code, String fullname, Qualification qualification) {
    	this.id= id;
        this.code = code;
        this.fullname = fullname;
        this.qualification = qualification;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getter and Setter for fullname
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // Getter and Setter for qualification
    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }
}
