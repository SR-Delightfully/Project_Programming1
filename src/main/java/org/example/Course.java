package org.example;
import lombok.*;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Course {
    // Field members:
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private Assignment[] assignments;
    private double[] finalScores;
    private static int nextId;

    public Course(String courseId, String courseName, double credits, Department department,Assignment[] assignments,double[] finalScores, int nextId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.finalScores = finalScores;
        this.nextId = nextId;
    }

    public boolean isAssignmentWeightValid() {
        //TODO:
        // check if sum of weights of all assignments of the course is equal to 1 (100%)
        return false;
    }

    public boolean registerStudent(Student student) {
        //TODO:
        // add a student to the student list of the course,
        // add new null element for each assignment in the course
        // add new null element for the finalScores
        return false;
    }

    public int[] calcStudentAverage() {
        //TODO:
        // calculate the weighted average score of a student
        int[] studentAverage;
        studentAverage = new int[]{0,0,0};
        return studentAverage;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        //TODO:
        // add new assignment to the course
        return false;
    }

    public void generateScores() {
        //TODO:
        // generate random scores for each assignemnt and student,
        // calculate the final score for each student.
    }

    public void displayScores() {
        //TODO:
        // Display the scores of the course in a table,
        // Contains assignment averages and student weighted averages
    }

    public String toSimplifiedString() {
        //TODO:
        // convert course to a string that contains
        // courseId, courseName, credits, departmentName, assignments, and registeredStudents.
        return "";
    }

    public String toString() {
        //TODO:
        // convert course to a string that contains courseId, courseName, credits,
        // departmentName, assignments, and registeredStudents
        return "";
    }
}
