package com.ailliushchenia.SchoolsWebFlux.domain;

import java.util.Objects;

public class School {
    private int id;
    private int number;
    private String name;
    private String address;

    public School(){}

    public School(int id) {
        this.id = id;
    }


    public School(int id, int number, String name, String address) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return id == school.id && number == school.number && Objects.equals(name, school.name) && Objects.equals(address, school.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, address);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
