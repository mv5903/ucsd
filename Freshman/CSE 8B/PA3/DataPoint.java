///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA3Tester.java
// File:               DataPoint.java
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
 * A particular DataPoint, which houses various information about case data
 * on a particular day, state, and various races.
 * @author Matthew Vandenberg
 */
public class DataPoint {
    // The number and races represented in this data point.  DO NOT CHANGE.
    public int numRaces = 8;
    private String[] races = {"White", "Black", "LatinX", "Asian", "AIAN",
                              "NHPI", "Multiracial", "Other"};
    private String date;
    private String state;
    private int totalCases;
    private int[] casesByRace;


    /**
     * Assign each parameter to its corresponding data member in DataPoint
     * @param dateIn Start date of cases on given day
     * @param stateIn State cases belong to
     * @param totalCasesIn Total cases on given day
     * @param casesByRaceIn Cases by race on given day
     */
    public DataPoint(String dateIn, String stateIn, int totalCasesIn,
                     int[] casesByRaceIn)
    {
        this.date = dateIn;
        this.state = stateIn;
        this.totalCases = totalCasesIn;
        this.casesByRace = casesByRaceIn;
    }

    /**
     * Returns the date of the cases
     * @return Date that the DataPoint refers to
     */
    public String getDate() {
        return this.date;
    }

   /**
    * Returns the state that the cases belong to
    * @return State that the DataPoint refers to
    */
    public String getState() {
        return this.state;
    }

    /**
     * Gets the cases by a particular race
     * @param raceIndex Index of requested race, according to casesByRace
     * @return Total number of cases of people that have the requested race
     */
    public int getCasesByRace(int raceIndex) {
        return this.casesByRace[raceIndex];
    }

    /**
     * Returns the total cases on a particular day
     * @return Cases
     */
    public int getTotalCases() {
        return this.totalCases;
    }

    /**
    * Return the race name associated with the given index in this data point.
    * Preconditions: index is between 0 (inclusive) and numRaces (8) (exclusive)
    *
    * DO NOT CHANGE.
    *
    * @param index The index of the race.
    * @return The name of the race (e.g. "White" or "LatinX")
    */
    public String getRaceName(int index)
    {
        return this.races[index];
    }
}
