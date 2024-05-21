package org.example;
import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    // Field members:
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    //private Course[] registeredCourses;
    private static int nextId = 1 ;

    // All arguments constructor:
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = getNextId();
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
    }

    public static String getNextId() {
        String num = Integer.toString(nextId);
        String zeroes = "";
        while (zeroes.length() + num.length() < 5) {
            zeroes += '0';
        }
        nextId++;
        return 'S' + zeroes + num;
    }

    //public boolean registerCourse(Course course) {
    public boolean registerCourse() {
        //TODO:
        // to register a course, add the course to the student's registeredCourses list
        // add the student to the course's registeredStudents list
        // Append a null for the scores of each assignment of the course
        // if course is already registered, directly return false.
        return false;
    }

    //public boolean dropCourse(Course course) {
    public boolean dropCourse() {
        //TODO:
        // to drop a course, remove the course from the student's registeredCourses list,
        // remove student from the course's registeredStudents list
        // if course is not registered yet, directly return false.
        return false;
    }

    public String toSimplifiedString() {
//        return  studentId + " " + studentName + " " + department.getDepartmentName();
        return "";
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department +
                '}';
    }
}
