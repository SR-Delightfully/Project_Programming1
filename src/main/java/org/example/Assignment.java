package org.example;
import lombok.*;

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
    }

    public void generateRandomScore() {
        //TODO:
        // generate random scores for all students in an assignemnt
        // if num is 0, generate random score in range of [0,60)
        // if num is 1 or 2, generate random score in range of [60,70)
        // if num is 3 or 4, generate random score in range of [70,80)
        // if num is 5,6,7 or 8, generate random score in range of [80, 90)
        // if num is 9 or 10, generate random score in range of [90,100)
    }

    public String toString() {
        //TODO:
        // generate string to represent an assignment
        // with assignment Id, assignmentName, weight, and maxScore.
        return "";
    }

}
