///////////////////////////////////////////////////////////////////////////////
// Main Class File:    SchoolTester.java
// File:               School.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * A class that maintains the attributes of a school. This includes the name
 * of the school and a list of students.
 *
 * Bugs: None found.
 *
 * @author (YOUR NAME)
 */
public class School {
    // DO NOT CHANGE THE CODE FOR THE PRIVATE MEMBER VARIABLES.
    private String name;
    private Student[] students;

    /**
     * Constructor to initialize the School object.
     * You should be performing a deep copy.
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     *
     * @param name the name to (deep) initialize with
     * @param students the students to (deep) copy from
     */
    public School(String name, Student[] students) {
        this.name = name;

        this.students = new Student[students.length];

        for (int student = 0; student < this.students.length; student++) {
            this.students[student] = students[student];
        }
    }

    /**
     * Getter method to return `name`.
     * 
     * DO NOT MODIFY THIS METHOD.
     * 
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method to return `students`.
     * 
     * DO NOT MODIFY THIS METHOD.
     * 
     * @return this.students
     */
    public Student[] getStudents() {
        return this.students;
    }

    /**
     * This method calculates the average (mean) score per student as a
     *  double. If the student name is "N/A", or if the student has
     *  no scores, their corresponding element should be `-1.0`.
     * 
     * No need to round the double to any decimal point - just leave it
     *  as is.
     * 
     * DO NOT MODIFY THE METHOD DECLARATION.
     * 
     * @return an array where each element represents the average score
     *  per student
     */
    public double[] meanScore() {
        // Create new array that will hold average values
        double[] averages = new double[students.length];

        // Cycle through each student's scores, calculating an average
        for (int student = 0; student < averages.length; student++) {
            double sum = 0;
            int[] scores = students[student].getScores();
            for (int score: scores) {
                sum += score;
            }
            // If there's no exam score or their name is N/A, score is -1.0
            if (sum == 0 || students[student].getName().equals("N/A")) {
                averages[student] = -1;
            } else {
                averages[student] = sum / scores.length;
            }
        }

        return averages;
    }

    /**
     * This method calculates the average (mean) score as a double for the\
     *  specified student. If the student name is "N/A", or if the student has
     *  no scores, then you should return `-1`. Be sure to check other
     *  edge cases.
     * 
     * No need to round the double to any decimal point - just leave it
     *  as is.
     * 
     * DO NOT MODIFY THE METHOD DECLARATION.
     * 
     * @return the average (mean) score of student at parameter `idx`.
     */
    public double meanScore(int idx) {
        double total = 0;
        if (idx < 0 || idx >= students.length) return -1.0;

        for (int score = 0; score < students[idx].getScores().length; score++) {
            total += students[idx].getScores()[score];
        }
        return total / students[idx].getScores().length;
    }
}
