package com.kristianskokars.services;

import com.kristianskokars.datastructures.MyGenericList;
import com.kristianskokars.model.Gender;
import com.kristianskokars.model.Student;

public class Main {
    public static void main(String[] args) {
        var students = new MyGenericList<>(Student.class, 3);

        Student jekabs = new Student("Jekabs", "HeLeftMe", new int[]{1, 1, 1, 1}, Gender.MALE);
        Student jekabs2 = new Student("Jekabs", "TheBetterOne", new int[]{10, 10, 10, 10}, Gender.MALE);
        Student kurts = new Student("Kurts", "Folkman", new int[]{6, 6, 9, 9}, Gender.MALE);
        Student marta = new Student("Marta", "Sleepy", new int[]{8, 8, 6, 6}, Gender.FEMALE);

        students.push(jekabs);
        students.push(jekabs2);
        students.push(kurts);
        students.push(marta);

        students.sort();
        students.print();
    }
}