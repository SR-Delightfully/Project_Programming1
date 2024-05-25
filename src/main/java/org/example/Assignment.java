package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    // Field members:
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private double assignmentAverage;
    private int maxScore;
    private int[] scores;
    private static int nextId;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = getNextId();
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
    }

    /**
     * provides a string containing the proceeding ID for the corresponding class.
     * @return a string that looks like "S001", "S002", "S003", etc.
     */
    public static String getNextId() {
        String num = Integer.toString(nextId);
        nextId++;
        return num;
    }

    /**
     * Calculates the average score for an assignment.
     */
    public void calcAssignmentAvg() {
        double avg;
        double sum = 0;
        int numScores = scores.length;

        for (int i=0; i<numScores; i++) {
            sum += scores[i];
        }

        avg = sum / numScores;
        System.out.println(avg);
    }

    /**
     * Generates a score, based on a set of rules and the generation of a random number.
     */
    public static void generateRandomScore() {
        Random random = new Random();
        int randNum = random.nextInt(10+1);
        int randScore = switch (randNum) {
            case 0 -> random.nextInt(0, 60 - 1);
            case 1, 2 -> random.nextInt(60, 70 - 1);
            case 3, 4 -> random.nextInt(70, 80 - 1);
            case 5, 6, 7, 8 -> random.nextInt(80, 90 - 1);
            case 9, 10 -> random.nextInt(90, 100);
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}
