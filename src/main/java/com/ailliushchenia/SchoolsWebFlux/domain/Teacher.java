package com.ailliushchenia.SchoolsWebFlux.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher {
    private int id;
    private String firstName;
    private String patronymic;
    private String surName;
    private List<School> schools = new ArrayList<>();

    public Teacher(){}


    public Teacher(int id, String firstName, String patronymic, String surName, List<School> schools) {
        this.id = id;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surName = surName;
        this.schools = schools;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(firstName, teacher.firstName) && Objects.equals(patronymic, teacher.patronymic) && Objects.equals(surName, teacher.surName) && Objects.equals(schools, teacher.schools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, patronymic, surName, schools);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surName='" + surName + '\'' +
                ", schools=" + schools +
                '}';
    }
}
