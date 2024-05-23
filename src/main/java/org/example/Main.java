package org.example;

import org.example.util.Util;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address(6540, "rue Beaulieu", "Montreal", "Quebec", "H4E3G3", "Canada");
        Department department1 = new Department("D1", "Department name", 0);
        Student student1 = new Student("John Doe", Gender.MALE, address1, department1);
        Student student2 = new Student("Jane Doe", Gender.FEMALE, address1, department1);
        Student student3 = new Student("Justice Doe", Gender.OTHER, address1, department1);

        System.out.println(Util.toTitleCase("computer science technology"));
//        Assignment assignment1 = new Assignment()

//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
    }
}