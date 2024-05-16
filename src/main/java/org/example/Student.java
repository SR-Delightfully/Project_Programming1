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
    //private Gender gender;
    private Department department;
    //private Course[] registeredCourses;
    private static int nextId;

    // All arguments constructor:
    public Student(String studentId, String studentName, Department department, int nextId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.nextId = nextId;
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
        //TODO:
        // convert student to a simple string with only studentId, studentName and departmentName
        // this method is called in Course toString().
        return "";
    }

    public String toString() {
        //TODO:
        // convert student to string that contains studentId, studentName, gender, address, department, and registeredCourses
        return "";
    }
}
