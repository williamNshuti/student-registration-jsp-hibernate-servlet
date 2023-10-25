package com.pack.model;

import javax.persistence.*;

@Entity
@Table(name = "Academic_unit")
public class AcademicUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unity_type")
    private UnityType unityType;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private AcademicUnit parentUnit;

    public AcademicUnit() {
    }

    public AcademicUnit(String code, String name, UnityType unityType, AcademicUnit parentUnit) {
        this.code = code;
        this.name = name;
        this.unityType = unityType;
        this.parentUnit = parentUnit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnityType getUnityType() {
        return unityType;
    }

    public void setUnityType(UnityType unityType) {
        this.unityType = unityType;
    }

    public AcademicUnit getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(AcademicUnit parentUnit) {
        this.parentUnit = parentUnit;
    }

    public enum UnityType {
        PROGRAMME,
        FACULTY,
        DEPARTMENT
    }
}