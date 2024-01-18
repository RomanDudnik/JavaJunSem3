package org.example.HmwrkTask1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int age;
    @JsonIgnore
    transient double gpa;

    public Student() {}

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }


    public void printFields() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
