package com.kristianskokars.model;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private static int lastId = 0;
    private final int id; // can be UUID or string
    private String name;
    private String surname;
    private int[] grades;
    private Gender gender;

    Student() {
        id = lastId;
        lastId++;
    }

    public Student(String name, String surname, int[] grades, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
        this.gender = gender;

        id = lastId;
        lastId++;
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

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public void findGender() {
        // TODO
    }

    public double averageGrade() {
        return Arrays.stream(grades).average().orElse(-1);
    }

    @Override
    public String toString() {
        return String.format("%1s %2s %3s %4s %5s", name, surname, id, gender, averageGrade());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;

        var other = (Student) obj;

        // TODO: do we need to check grades too? Would we only want to check ID for find?
        return
                this.id == other.id
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.surname, other.surname)
                && this.gender == other.gender;
    }

    @Override
    public int compareTo(Student other) {
        if (this == null) {
            return -1;
        }

        if (other == null) {
            return 1;
        }


        return Double.compare(this.averageGrade(), other.averageGrade());
    }
}
