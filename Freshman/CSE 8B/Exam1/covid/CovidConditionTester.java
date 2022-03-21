///////////////////////////////////////////////////////////////////////////////
// Main Class File:    CovidConditionTester.java
// File:               CovidCondition.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             (YOUR NAME)
// Email:              (YOUR EMAIL ADDRESS)
// Instructor's Name:  (NAME OF YOUR INSTRUCTOR)
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * A class to test the CovidCondition class.
 *
 * Bugs: None known
 *
 * @author (YOUR NAME)
 */
public class CovidConditionTester {
    /**
     * Execution point of testing code for the CovidCondition class.
     * DO NOT MODIFY METHOD DECLARATION.
     */
    public static void main(String[] args) {
        CovidCondition cali = new CovidCondition("California", 76);
        CovidCondition oregon = new CovidCondition("Oregon", 23);

        // Checking `cali.getDetails()` is what I expect.
        // Expecting to see "California currently has a daily average of 76 thousand cases".
        // So if the String is anything else, then the test has failed.
        if (!cali.getDetails().equals("California currently has a daily average of 76 thousand cases")) {
            System.out.println("Test 1 Failed!");
            return; // `return` early so we do not run any subsequent tests. 
        }

        // Checking `oregon.checkTier()` is "Orange".
        // If it is not "Orange", then the test has failed.
        if (!oregon.checkTier().equals("Orange")) {
            System.out.println("Test 2 Failed!");
            return;
        }

        // You should write more tests to ensure proper functionality of your code.
        // Video
        CovidCondition state1 = new CovidCondition("California", 120);
        CovidCondition state2 = new CovidCondition("Utah", 10);

        // Line 1
        // String state1Details = state1.getDetails();
        // System.out.println(state1Details);

        // Line 2
        String state2Tier = state2.checkTier();
        System.out.println(state2Tier);
    }
}
