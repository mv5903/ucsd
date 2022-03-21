///////////////////////////////////////////////////////////////////////////////
// Main Class File:    BarChartRacer.java
// File:               Bar.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
// NO HELP OR PAIR PROGRAMMING USED
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Implementation to create a single Bar in a BarChart
 *
 * Bugs: None known
 *
 * @author Matthew Vandenberg
 */

public class Bar implements Comparable<Bar> {
    private String name;
    private int value;
    private String category;

    /**
     * Bar constructor
     * @param name Name of city
     * @param value Number of whatevers
     * @param category Name of state, country
     */
    public Bar(String name, int value, String category) {
        this.name = name;
        this.value = value;
        this.category = category;
    }

    /**
     * Returns name of item
     * @return name of item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns value of item
     * @return value of item
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Returns category of item
     * @return category of item
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Properly defines how a bar should be compared to another one
     * @param that Bar to compare
     */
    public int compareTo(Bar that) {
        if (this.value > that.value) return 1;
        if (this.value < that.value) return -1;
        return 0;
    }
}
