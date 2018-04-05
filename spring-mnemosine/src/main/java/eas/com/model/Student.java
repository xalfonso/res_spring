package eas.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author esanchez
 */
public class Student {

    private String name;

    private String surname;

    private char sex;

    private List<String> interest;


    public Student(String name, String surname, char sex, List<String> interest) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.interest = interest;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    @JsonIgnore
    public String getInterestString() {
        return this.interest == null ? "" : interest.stream().collect(Collectors.joining(","));
    }
}
