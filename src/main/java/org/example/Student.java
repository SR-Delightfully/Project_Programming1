package org.example;
import lombok.*;
import org.example.util.Util;
import java.util.ArrayList;

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
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1 ;

    // All arguments constructor:
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = getNextId();
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
    }

    /**
     * provides a string containing the proceeding ID for the corresponding class.
     * @return a string that looks like "S001", "S002", "S003", etc.
     */
    public static String getNextId() {
        String num = Integer.toString(nextId);
        String zeroes = "";
        while (zeroes.length() + num.length() < 5) {
            zeroes += '0';
        }
        nextId++;
        return 'S' + zeroes + num;
    }

    /**
     * adds a new Course class to the list of registeredCourses, and appends null fpr each assignment in the class.
     * @param course an object representing a school course and contains that pertaining information.
     * @return true if the Course has been appended, false if not.
     */
    public boolean registerCourse(Course course) {

        for (Course registeredCourse : registeredCourses) {
            if (registeredCourse == course) {
                return false;
            } else {
                registeredCourses.add(course);
                course.registerStudent(this);

//                Assignment[] assignments = course.getAssignments();
//                int[] scores = assignments.getScores();
//
//                for (int i=0; i < assignments.length; i++) {
//                    for (int j=0; j < assignments.length; j++) {
//                        scores[j] = (Integer) null;
//                    }
//                }
            }
        }
        return true;
    }

    /**
     * removes a new Course class to the list of registeredCourses.
     * @param course an object representing a school course and contains that pertaining information.
     * @return true if the Course has been removed, false if not.
     */
    public boolean dropCourse(Course course) {

        for (Course registeredCourse : registeredCourses) {
            if (registeredCourse != course) {
                return false;
            } else {
                registeredCourses.remove(course);
                course.registeredStudents.remove(this);
            }
        }

        return false;
    }

    public String toSimplifiedString() {
        return  studentId + " " + studentName + " " + department.getDepartmentName();
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
