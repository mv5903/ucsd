
///////////////////////////////////////////////////////////////////////////////
// Main Class File:    RaggedArrayTester.java
// File:               RaggedArray.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

/**
 * A class that maintains a 2D array. The 2D array could be ragged (i.e. not
 * neccesarily a rectangular array).
 *
 * Bugs: Something is wrong with `findMaxWrong()`...
 *
 * @author (YOUR NAME)
 */
public class RaggedArray {
    // DO NOT CHANGE THE CODE FOR THE PRIVATE MEMBER VARIABLE.
    private int[][] myArray;

    /**
     * Constructor to initialize the RaggedArray via an integer array.
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     *
     * @param arrayIn the array to DEEP copy into myArray
     */
    public RaggedArray(int[][] arrayIn) {
        // Find largest row (most amount of items)
        int largestCount = 0;
        for (int[] row: arrayIn) {
            int count = 0;
            for (int num: row) {
                count++;
            }
            if (count > largestCount) largestCount = count;
        }

        // Create new array
        myArray = new int[arrayIn.length][largestCount];

        // Copy all items into new array manually
        for (int row = 0; row < arrayIn.length; row++) {
            for (int col = 0; col < arrayIn[row].length; col++) {
                myArray[row][col] = arrayIn[row][col];
            }
        }
    }

    /**
     * Constructor to initialize the RaggedArray via an input file.
     * 
     * NOTE: If initializing RaggedArray with an input file, then
     *  myArray is guaranteed to be a rectangular 2D array.
     * 
     * DO NOT MODIFY THE CONSTRUCTOR DECLARATION.
     *
     * @param inputPath the file to read and create for myArray
     */
    public RaggedArray(String inputPath) throws IOException {
        Scanner reader = new Scanner(new File(inputPath));

        // Create array and grab new dimensions from first two numbers
        myArray = new int[reader.nextInt()][reader.nextInt()];

        // Copy numbers from file into myArray
        for (int row = 0; row < myArray.length; row++) {
            for (int col = 0; col < myArray[row].length; col++) {
                myArray[row][col] = reader.nextInt();
            }
        }

        // Close the Scanner
        reader.close();
    }

    /**
     * Getter method for returning `myArray`.
     * 
     * DO NOT MODIFY THIS METHOD.
     *
     * @return this.myArray
     */
    public int[][] getMyArray() {
        return this.myArray;
    }
    
    /**
     * Finds the maximum element in myArray, but there is an error...
     * Can you find the error?
     * 
     * DO NOT MODIFY THIS METHOD.
     *
     * @return an integer that represents the maximum element from `myArray`
     */
    public int findMaxWrong() {
        int max = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (myArray[i][j] > max) {
                    max = myArray[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Finds the maximum element in myArray, but the error should be fixed.
     * Use `findMaxWrong()` as template code, and fix the error.
     * 
     * DO NOT MODIFY METHOD DECLARATION.
     *
     * @return an integer that represents the maximum element from `myArray`
     */
    public int findMax() {
        
        int maxNumber = 0;

        for (int row = 0; row < myArray.length; row++) {
            for (int col = 0; col < myArray[row].length; col++) {
                if (myArray[row][col] > maxNumber) {
                    maxNumber = myArray[row][col];
                }
            }
        }

        return maxNumber;
    }
}