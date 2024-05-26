package org.example;
import lombok.*;
import org.example.util.Util;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


@NoArgsConstructor
@ToString
@EqualsAndHashCode
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

//        finalScores.add(null);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

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
            for (int j=0; j < assignments.size(); j++) {
                ArrayList<Integer> scores = assignments.get(j).getScores();
                double weight = assignments.get(j).getWeight();
                total += scores.get(j) * weight;
            }
            weightedScores[i] = (int) (total * 100);
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
        Random random = new Random();

        for (int i=0; i<assignments.size(); i++) {
            for (int j=0; j<assignments.get(i).getScores().size(); j++) {
                Assignment assignment = assignments.get(i);
                assignment.getScores().set(i, random.nextInt(0, assignment.getMaxScore()));
            }
        }

        for (int i=0; i < finalScores.size(); i++) {
            double total = 0;

            for (int j=0; j < assignments.size(); j++) {
                Assignment assignment = assignments.get(i);

                double currentScore = (double) assignment.getScores().get(i);
                double maxScore = assignment.getMaxScore();
                double weight = assignment.getWeight();

                total += currentScore / maxScore * weight;
            }

            finalScores.set(i, total * 100);
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

    // Adding getters manually to get rid of "errors"...
    public String getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public double getCredits() {
        return credits;
    }
    public Department getDepartment() {
        return department;
    }
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }
    public ArrayList<Double> getFinalScores() {
        return finalScores;
    }
}
