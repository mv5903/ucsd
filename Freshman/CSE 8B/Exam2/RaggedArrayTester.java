
///////////////////////////////////////////////////////////////////////////////
// Title:              RaggedArray
// Files:              RaggedArrayTester.java, RaggedArray.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.IOException;

/**
 * A class to test the RaggedArray class.
 *
 * Bugs: None known
 *
 * @author (YOUR NAME)
 */
public class RaggedArrayTester {
    /**
     * Execution point of testing code for the RaggedArray class.
     * 
     * DO NOT MODIFY METHOD DECLARATION.
     */
    public static void main(String[] args) throws IOException {
        int[][] input1 = {{1, 5, 23}, {6, 2, 85}, {3, 76, 13}};
        RaggedArray ra1 = new RaggedArray(input1);
        
        String file1 = "input1";
        RaggedArray ra2 = new RaggedArray(file1);

        // Testing for simple assignment within constructor.
        // We do NOT want a shallow copy - we want a deep copy.
        // As such, if both arrays have the same reference, then this test fails.
        if (ra1.getMyArray() == input1) {
            System.out.println("Test Failed! Shallow copy detected.");
        }

        // Testing `findMax()` for `ra1`.
        // The max should be 85, so if the return value is not 85, then this test fails.
        if (ra1.findMax() != 85) {
            System.out.println("Test Failed! `ra1.findMax()` was NOT 85.");
        }

        // Testing `findMax()` for `ra2`.
        // The max should be 5, so if the return value is not 5, then this test fails.
        if (ra2.findMax() != 5) {
            System.out.println("Test Failed! `ra2.findMax()` was NOT 5.");
        }


        // You should write more tests to ensure constructor functionality (and deep copy),
        // and to test `findMax()`.

        // TEST CASE FOR VIDEO PART 1
        int[][] testFindMax = new int[][] {
            {1, 2, 3, 4},
            {1, 2, 3, 4},
            {1, 2, 3, 4}
        };
        RaggedArray arr = new RaggedArray(testFindMax);
        System.out.println(arr.findMaxWrong());
    }
}
