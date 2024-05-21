package org.example;
import lombok.*;

import java.util.Arrays;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    // Field members:
    private String assignmentId;
    private String assignemntName;
    private double weight;
    private double assignmentAverage;
    private int maxScore;
    private int[] scores;
    private static int nextId;

    public void calcAssignmentAvg() {
        //TODO:
        // calculate average score for one assignment
        int[] testScores = {70, 95, 63, 85, 37};

    }

    public void generateRandomScore() {
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
                ", assignemntName='" + assignemntName + '\'' +
                ", weight=" + weight +
                ", assignmentAverage=" + assignmentAverage +
                ", maxScore=" + maxScore +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }
}
