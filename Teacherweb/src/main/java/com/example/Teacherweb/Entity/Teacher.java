package com.example.Teacherweb.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String subject;
    //    @OneToOne(cascade = CascadeType.ALL)
    private String department;
    //    @OneToOne(cascade = CascadeType.ALL)
    private String section;

    public Teacher() {
    }
    public Teacher(Integer id,String name, String subject,String department, String section){
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.department = department;
        this.section = section;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", department='" + department + '\'' +
                ", section='" + section + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(), teacher.getId()) && Objects.equals(getName(), teacher.getName()) && Objects.equals(getSubject(), teacher.getSubject()) && Objects.equals(getDepartment(), teacher.getDepartment()) && Objects.equals(getSection(), teacher.getSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSubject(), getDepartment(), getSection());
    }
}
