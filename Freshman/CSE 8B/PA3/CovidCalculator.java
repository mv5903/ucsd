///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA3Tester.java
// File:               CovidCalculator.java
// Quarter:            CSE8B Winter 2022
// Author:             Matthew Vandenberg
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       Not Used
// Email:              NA
// Instructor's Name:  NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          NA
//
// Online sources:   NA
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Calculator class that performs various operations given a set of Covid-19
 * case data.
 * @author Matthew Vandenberg
 */
class CovidCalculator {
    private DataPoint[] points;  // The data points to use in the calculations

    /**
     * Takes an array of DataPoints and copies the data into a new array, 
     * creating a CovidCalculator object
     * @param input Array to copy into a CovidCalculator object.
     */
    public CovidCalculator(DataPoint[] input)
    {
        // Iterate through each element in the array, copying each term into
        // the corresponding position of the new array for the CovidCalculator
        // object
        DataPoint[] newPoints = new DataPoint[input.length];
        for (int i = 0; i < input.length; i++) {
            newPoints[i] = input[i];
        }
        this.points = newPoints;
    }

    /**
     * Given a date, find the average of all cases on that particular date from 
     * all states.
     * @param date Date to find all cases and take the average
     * @return Average cases
     */
    public double findAverageCases(String date)
    {
        // For each DataPoint that matches the date, add to sum total, and add
        // to the number of DataPoints to include when calculating the average
        // at the end.
        int numDataPoints = 0;
        double sum = 0;
        for (DataPoint point: this.points) {
            if (point.getDate().equals(date)) {
                sum += (double) point.getTotalCases();
                numDataPoints++;
            }
        }
        // Returns 0 if this.points doesn't contain the date anywhere in array
        if (numDataPoints == 0) return 0;
        return sum/numDataPoints;
    }

    /**
     * Given a particular date and state, narrow the data down to one 
     * particular DataPoint. Using this DataPoint, locate the race--
     * which corresponds to the casesByRace array--that has the highest amount
     * of cases.
     * @param date Date of the particular DataPoint
     * @param state State of the particular DataPoint
     * @return Race as String that has the highest number of cases
     */
    public String findRaceWithHighestCases(String date, String state)
    {
        // Find particular DataPoint that matches the date and state
        DataPoint correctPoint = points[0];
        for (DataPoint point: points) {
            if (point.getDate().equals(date) && point.getState().equals(state)) {
                correctPoint = point;
                break;
            }
        }

        // Iterate through each case by race, locating the highest race case amount
        String highestRace = "White";
        int highestCount = 0;
        for (int i = 0; i < correctPoint.numRaces; i++) {
            int count = correctPoint.getCasesByRace(i);
            if (count > highestCount) {
                highestCount = count;
                highestRace = correctPoint.getRaceName(i);
            }
        }

        return highestRace;
    }

    /**
     * +++ Freestyle Method +++
     * Returns the race that has the lowest number of cases all time throughout
     * any state or date in the data.
     * @return Race with lowest total cases
     */
    public String findRaceWithLowestCasesAllTime() {
        // Simple array will store the totals for each race
        int[] raceCounts = new int[points[0].numRaces];

        // Iterate through each dataPoint, adding the corresponding totals
        for (DataPoint dataPoint: points) {
            for (int j = 0; j < raceCounts.length; j++) {
                raceCounts[j] += dataPoint.getCasesByRace(j);
            }
        }

        // Locate which race has the lowest amount of cases based on raceCounts
        String lowestRace = "White";
        int lowestCount = raceCounts[0];
        for (int i = 0; i < raceCounts.length; i++) {
            if (raceCounts[i] < lowestCount) {
                lowestCount = raceCounts[i];
                lowestRace = points[0].getRaceName(i);
            }
        }

        return lowestRace;
    }


}
