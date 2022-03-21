///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA3 - Covid Calculator
// Files:              PA3Tester.java, PA3Library.java, DataPoint.java, 
//                      CovidCalculator.java
// Quarter:            CSE8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                  If pair programming is allowed:
//                  1. Read PAIR-PROGRAMMING policy
//                  2. Choose a partner wisely
//                  3. Complete this section for each program file
//
// Pair Partner:        Not Used
// Email:               NA
// Instructors's Name:  NA
// Lab Section:         NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          NA
//
// Online sources:   NA
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

// TODO: Add the appropriate class header comment here.
public class PA3Tester {

    /**
    * Method that tests the DataPoint class.  It creates two fake points
    * and then prints out the expected values and actual values stored in each.
    *
    * Takes no parameters and returns nothing.  Point values are hard-coded.
    *
    * TODO: Add the tests of a second DataPoint.
    */
    private static void testDataPoints()
    {
        System.out.println("***Running Data Point tests***");
        System.out.println("");

        // Create a made up data point for testing
        int[] testRaceData1 = {20, 3000, 463, 28, 900, 100, 400, 100};
        String testDate1 = "20210113";
        String testState1 =  "CA";
        int testTotalCases1 = 5011;
        DataPoint test1 = new DataPoint(testDate1, testState1,
                                        testTotalCases1, testRaceData1);

        // Run tests on the first data PointTester
        System.out.println("Testing DataPoint 1");
        System.out.println("Expected Date: " + testDate1);
        System.out.println("Actual Date: " + test1.getDate());
        System.out.println("");

        System.out.println("Expected State: " + testState1);
        System.out.println("Actual State: " + test1.getState());
        System.out.println("");

        System.out.println("Expected Total Cases: " + testTotalCases1);
        System.out.println("Actual Total Cases: " + test1.getTotalCases());
        System.out.println("");

        System.out.println("Expected Cases by Race: " +
        "[20, 3000, 463, 28, 900, 100, 400, 100]");
        System.out.print("Actual Cases by Race: [");
        for (int index = 0; index < test1.numRaces; index++) {
            System.out.print(test1.getCasesByRace(index) + ", ");
        }
        System.out.println("]");
        System.out.println("");


        // TODO: Create a second made up data point for testing and run tests
        // on that point.  You can copy the code from above and modify it as
        // needed.

        System.out.println("***Running Data Point tests***");
        System.out.println("");

        // Create a made up data point for testing
        int[] testRaceData2 = {200, 300, 563, 68, 100, 1001, 40000, 1000};
        String testDate2 = "20210125";
        String testState2 =  "NJ";
        int testTotalCases2 = 43232;
        DataPoint test2 = new DataPoint(testDate2, testState2,
                                        testTotalCases2, testRaceData2);

        // Run tests on the first data PointTester
        System.out.println("Testing DataPoint 1");
        System.out.println("Expected Date: " + testDate2);
        System.out.println("Actual Date: " + test2.getDate());
        System.out.println("");

        System.out.println("Expected State: " + testState2);
        System.out.println("Actual State: " + test2.getState());
        System.out.println("");

        System.out.println("Expected Total Cases: " + testTotalCases2);
        System.out.println("Actual Total Cases: " + test2.getTotalCases());
        System.out.println("");

        System.out.println("Expected Cases by Race: " +
        "[200, 300, 563, 68, 100, 1001, 40000, 1000]");
        System.out.print("Actual Cases by Race: [");
        for (int index = 0; index < test2.numRaces; index++) {
            System.out.print(test2.getCasesByRace(index) + ", ");
        }
        System.out.println("]");
        System.out.println("");

    }

    /**
    * Method that tests the CovidCalculator class.  It takes an array of
    * all available DataPoints from the file "COVID_19_Data.CSV".
    * It then creates two smaller arrays using a subset of those points and
    * uses those smaller arrays to test the methods in CovidCalculator.
    *
    * Preconditions: allPoints contains the data from COVID_19_Data.CSV.
    *
    * TODO: Add the tests of a second CovidCalculator with a different
    *  subset of DataPoints.
    */
    private static void testCovidCalculator(DataPoint[] allPoints)
    {
        System.out.println("");
        System.out.println("*** First CovidCalculator Tests ***");
        DataPoint[] testSubset1 = new DataPoint[5];
        // Copy 5 points into the testSubset1 array.
        // Choose points such that we get two states that are repeated.
        // Points 1, 6, and 13 are from CA, and 1 and 7 are from CO
        testSubset1[0] = allPoints[0];
        testSubset1[1] = allPoints[1];
        testSubset1[2] = allPoints[6];
        testSubset1[3] = allPoints[7];
        testSubset1[4] = allPoints[13];

        CovidCalculator ccTest1 = new CovidCalculator(testSubset1);

        // Test each method.  We have hand-calculated the expected values.
        System.out.println("");
        System.out.println("First test set:");

        // Tests of findAverageCases
        // Test where the average is not an integer
        System.out.println("Average Cases on 20210113: ");
        System.out.println("\tExpected: 1,573,906.5");
        System.out.println("\tActual: " + ccTest1.findAverageCases("20210113"));
        System.out.println("");

        // Test a date that is not in the subset
        System.out.println("Average Cases on 20201215: ");
        System.out.println("\tExpected: 0.0");
        System.out.println("\tActual: " + ccTest1.findAverageCases("20201215"));
        System.out.println("");

        // Tests of findRaceWithHighestCases
        System.out.println("Race in CA with highest cases on 20210110:");
        System.out.println("\tExpected: LatinX");
        System.out.println("\tActual: " +
                            ccTest1.findRaceWithHighestCases("20210110", "CA"));

        System.out.println("Race in CO with highest cases on 20210110:");
                            System.out.println("\tExpected: White");
                            System.out.println("\tActual: " +
                            ccTest1.findRaceWithHighestCases("20210110", "CO"));



        // Test of myStat
        // TODO Add at least two tests here using ccTest1
        System.out.println("Lowest Race Cases total with ccTest1:");
        System.out.println("Expected: AIAN");
        System.out.println("Actual: " + ccTest1.findRaceWithLowestCasesAllTime());

        // Because we're allowed to have no parameters, there's no other test I can run!


        // TODO: create a second test subset of data points, make another
        // CovidCalculator with this second subset, and write at least two tests
        // for each of the CovidCalculator methods using this new
        // CovidCalculator object.
        System.out.println("***** Second Test Subset ****");

        CovidCalculator ccTest2 = new CovidCalculator(new DataPoint[] {
            allPoints[0],
            allPoints[3],
            allPoints[6],
            allPoints[12],
            allPoints[13],
            allPoints[21],
            allPoints[27]
        });

        System.out.println("");
        System.out.println("Second test set:");

        // Tests of findAverageCases
        // Test where the average is not an integer
        System.out.println("Average Cases on 20210113: ");
        System.out.println("\tExpected: 1,417,582.0");
        System.out.println("\tActual: " + ccTest2.findAverageCases("20210113"));
        System.out.println("");

        // Test a date that is not in the subset
        System.out.println("Average Cases on 20201215: ");
        System.out.println("\tExpected: 0.0");
        System.out.println("\tActual: " + ccTest2.findAverageCases("20201215"));
        System.out.println("");

        // Tests of findRaceWithHighestCases
        System.out.println("Race in CA with highest cases on 20210110:");
        System.out.println("\tExpected: LatinX");
        System.out.println("\tActual: " +
                            ccTest2.findRaceWithHighestCases("20210110", "CA"));

        System.out.println("Race in CO with highest cases on 20210110:");
        System.out.println("\tExpected: LatinX");
        System.out.println("\tActual: " +
        ccTest2.findRaceWithHighestCases("20210110", "CO"));

        // Test of myStat
        System.out.println("Lowest Race Cases total with ccTest1:");
        System.out.println("Expected: AIAN");
        System.out.println("Actual: " + ccTest2.findRaceWithLowestCasesAllTime());





    }

    /**
    * Run the tests of DataPoint and CovidCalculator.
    * Then run each of the CovidCalculator methods on the full data
    * from COVID_19_Data.CSV.
    *
    * Preconditions: The file COVID_19_Data.CSV contains all of the data
    *   and is in the directory where this code is run.
    *
    * @param args Command line arguments (not used)
    */
    public static void main(String[] args) {
        // Run the data point tester
        testDataPoints();

        // Read in the data from the file
        int numCSVRows = 310;
        PA3Library lib = new PA3Library();
        DataPoint[] points = lib.readFile("COVID_19_Data.CSV");

        // Run the Covid Calculator tester
        testCovidCalculator(points);

        // Finally, read the data from the file and compute the statistics for
        // the full file.  You may modify the code below to explore the data.
        CovidCalculator calculator = new CovidCalculator(points);

        System.out.println("****** Full Data Set *******\n");

        System.out.print("The average number of cases across all states ");
        System.out.print("on 20210106 is ");
        System.out.println(calculator.findAverageCases("20210106"));

        System.out.print("The race with the highest number of cases in CO ");
        System.out.print(" on 20200524 was ");
        System.out.println(calculator.findRaceWithHighestCases("20200524", "CO"));

        // TODO: Print the results of your data exploration with
        // your statistic here.

        System.out.println("The race with lowest number of cases all time:");
        System.out.println("Expected: AIAN");
        System.out.println("Actual: " + calculator.findRaceWithLowestCasesAllTime());


    }
}
