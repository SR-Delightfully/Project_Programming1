package org.example;

import org.example.util.Util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address(6540, "rue Beaulieu", "Montreal", "Quebec", "H4E3G3", "Canada");
        Department department1 = new Department("D1", "Department name");
        double[] finalScores = {0.89, 0.64, 0.72};

        Assignment assignment1 = new Assignment("Assignment1",3.3, 100);
        Assignment assignment2 = new Assignment("Assignment2",3.3, 100);
        Assignment assignment3 = new Assignment("Assignment3",3.3, 100);
        ArrayList<Assignment> assignments = new ArrayList<>();
        assignments.add(assignment1);
        assignments.add(assignment2);
        assignments.add(assignment3);

        Student student1 = new Student("John Doe", Gender.MALE, address1, department1);
        Student student2 = new Student("Jane Doe", Gender.FEMALE, address1, department1);
        Student student3 = new Student("Justice Doe", Gender.OTHER, address1, department1);
        Student[] students = {student1, student2, student3};

        Course course1 = new Course("Programming", 3.00, department1, assignments, students, finalScores);
        System.out.println(course1.displayScores());

        //System.out.println(Util.toTitleCase("computer science technology"));
        //Assignment assignment1 = new Assignment()


    }
}