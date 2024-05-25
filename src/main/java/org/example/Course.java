package org.example;
import lombok.*;
import org.example.util.Util;

import java.util.Arrays;
import java.util.ArrayList;


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
    private ArrayList<Assignment> assignments;
    public ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1 ;

    public Course(String courseName, double credits, Department department,ArrayList<Assignment> assignments, Student[] registeredStudents, double[] finalScores) {
        this.courseId = getNextId();
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * provides a string containing the proceeding ID for the corresponding class.
     * @return a string that looks like "S001", "S002", "S003", etc.
     */
    public static String getNextId() {
        String num = Integer.toString(nextId);
        nextId++;
        return '0' + num;
    }

    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            double weight = assignment.getWeight();
            sum += weight;
        }
        return (sum == 1);
    }

    public boolean registerStudent(Student student) {
        registeredStudents.add(student);
        student.registerCourse(this);

        finalScores.add(null);

//        for (Assignment assignment : assignments) {
//            assignment.getScores().add(null);
//        }

        return true;
    }

    /**
     * Calculates the weighted average of a student
     * @return a new int[] with the new weighted averages.
     */
    public int[] calcStudentAverage() {
        int[] weightedScores = new int[registeredStudents.size()];

        for (int i = 0; i < weightedScores.length; i++) {
            double total = 0;
            for (Assignment assignment : assignments) {
                int[] scores = assignment.getScores();
                double weight = assignment.getWeight();
                total += scores[i] * weight;
            }
            weightedScores[i] = (int) total * 100;
        }

        return weightedScores;
    }

    /**
     * adds a new assignment to the course
     * @param assignmentName
     * @param weight
     * @param maxScore
     * @return true if assignment has been added, false if not.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(assignment);
        return true;
    }


    /**
     * generates random scores for each student's assignment and calculates the final score each student.
     */
    public void generateScores() {
        //TODO:
        // generate random scores for each assignment and student,
        // calculate the final score for each student.
        for (int i=0; i<assignments.size(); i++) {
            if (assignments.get(i) == null) {
                //assignments[i] = Assignment.generateRandomScore(); //???
            }
        }
    }

    /**
     * Displays information relating to scores.
     * @return true if there is enough information to print, false if not.
     */
    public boolean displayScores() {
        //TODO:
        // Display the scores of the course in a table,
        // Contains assignment averages and student weighted averages
        if (courseName == null ||  department == null || courseId == null) {
            System.out.println("Please provide more information to display scores.");
            return false;
        } else {
            String departmentId = this.department.getDepartmentId();
            System.out.println("Course        : " + this.courseName + " (C-" + departmentId + "-" + this.courseId + ")");
            System.out.print("Names         : ");
            for (int a = 0; a < assignments.size(); a++){
                String assignmentName = assignments.get(a).getAssignmentName();
                System.out.print(assignmentName + " ");
            }
            System.out.print("FinalScore");
            System.out.println(" ");
            for (int s = 0; s < registeredStudents.size(); s++){
                String studentName = registeredStudents.get(s).getStudentName();
                System.out.println(studentName);
                // for each student's assignments, print scores??
                // I'm confused about scores since it's in the assignment class,
                // how do we know which score is for which student?
            }
            System.out.println("Averages: ");
            //print averages

            return true;
        }
    }

    public String toSimplifiedString() {
        return courseId + " " + courseName + " " + credits + " " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
