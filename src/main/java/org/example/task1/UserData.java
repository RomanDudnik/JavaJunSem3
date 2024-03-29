package org.example.task1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class UserData implements Serializable {
    private String name;
    private int age;

    @JsonIgnore                 // Анотация для игнорирования поля (для библиотеки jackson)
    transient String password;

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }




    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
