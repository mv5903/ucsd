///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Programming Assignment 1 - Question Answer
// Files:              CSE8B_PA1.java (just this file)
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//

package PA1;
import java.util.Scanner;

/**
 * CSE 8B Programming Assignment 1, requires 3 questions and answers on a particular computer scientist.
 * This assignment will have questions and answers based on Margaret Hamilton
 * 
 * Bugs: None. Program works as intended.
 * 
 * @author Matthew Vandenberg
 */
public class CSE8B_PA1 {
    /**
     * Program execution begins here.
     * @param args Not used in this program.
     */
    public static void main(String[] args) {
        // Scanner object that will be used for reading user input
        Scanner kbd = new Scanner(System.in);
        // Counter variable to keep track of how many questions were answered correctly
        int totalCorrect = 0;

        // Introduction
        System.out.println("Welcome to the Margaret Hamilton quiz! I'm going to ask you some question to see how much you know about her.\n");

        // First Question
        System.out.println("Margaret Hamilton developed on-board software for which company?");
        if (kbd.nextLine().equals("NASA")) {
            System.out.println("Correct!");
            totalCorrect++;
        } else {
            System.out.println("That's not it. The answer was NASA.");
        }

        // Second Question
        System.out.println("Hamilton received a Presidential Medal of Freedom in 2016. Which president gave it to her?");
        System.out.println("A. Former President Donald J Trumnp");
        System.out.println("B. Former President Barack Obama");
        System.out.println("C. President Joseph Biden");
        if (kbd.nextLine().equals("B")) {
            System.out.println("That's right!");
            totalCorrect++;
        } else {
            System.out.println("Not quite. She received the medal from former President Barack Obama.");
        }

        // Third and final question
        System.out.println("How old is Hamilton as of Jan 5 2022?");
        if (kbd.nextInt() == 85) {
            System.out.println("Yep!");
            totalCorrect++;
        } else {
            System.out.println("That's not correct. She's currently 85.");
        }

        // We're done with the scanner, so let's close it
        kbd.close();

        // Final score
        if (totalCorrect == 0) {
            System.out.println("Ouch. Looks like you don't know much about Margaret Hamilton!");
        } else if (totalCorrect == 1) {
            System.out.println("Looks like you at least got one question correct. Try again and do better next time!");
        } else if (totalCorrect == 2) {
            System.out.println("You got 2 out of 3 correct. Not bad!");
        } else {
            System.out.println("You're a genius! You know Margaret Hamilton very well!");
        }
    }
}
