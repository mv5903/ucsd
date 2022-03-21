///////////////////////////////////////////////////////////////////////////////
// Main Class File:    EasterEggTester.java
// File:               EasterEgg.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;

/**
 * A class that helps strategize 
 * for the EasterEgg race.
 *
 * Bugs: Something is weird about `recursiveSum`...
 *
 * @author Matthew Vandenberg
 */
public class EasterEgg {
	
    /**
     * Generates an array of scores based 
     * on the elements in the eggs ArrayList
     * 
     * @param eggs - an ArrayList of Strings that denote the type of egg
     */
	public int[] calculateScores(ArrayList<String> eggs) throws Exception {
        int[] scores = new int[eggs.size()];
        for (int i = 0; i < eggs.size(); i++) {
            String currentEgg = eggs.get(i);
            if (currentEgg.equals("Chocolate")) {
                scores[i] = (i + 1) * 10;
            }
            else if (currentEgg.equals("Golden")) {
                scores[i] = (i + 1) * 10 * 2;
            } 
            else {
                throw new Exception("Invalid Easter Egg");
            }
        }
        return scores;
	}
    
    /**
     * Recursively calculates the highest score possible
     * 
     * @param scores[] - integer array of all the scores of each egg
     * @param idx - index of first or index of last element of scores
     *  (depending on your implementation.)
     */
    public int maxScore(int scores[], int idx) {
        if (idx >= scores.length) return 0;
        if (idx == scores.length - 1) return scores[idx];
        if (idx == 0) return scores[idx] + maxScore(scores, idx+2);
        if (scores[idx] > scores[idx + 1]) {
            return scores[idx] + maxScore(scores, idx+1);
        } else {
            return maxScore(scores, idx+1);
        }
    }	

    /**
     * Recursively calculates the sum of numbers from 1 to the 
     * parameter `num`, but there is an error...
     * 
     * @param num - number up to which the sum is calculated 
     */
    public int recursiveSum(int num){
        if (num < 0) return 0;
        return num + recursiveSum(num - 1);
    }	
}
