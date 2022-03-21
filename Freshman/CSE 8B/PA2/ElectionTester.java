///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA2 - Election Results
// Files:              ElectionTester.java, Election.java, Candidate.java
// Quarter:            CSE 8B Winter 2022
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
// Persons:          Not Used
//
// Online sources:   not used
//////////////////////////// 80 columns wide //////////////////////////////////

package PA2;

import java.util.Scanner;

/**
 * ElectionTest class for the Election and Candidate classes.
 */
public class ElectionTester {

    /**
     * Tester for the Candidate Class
     * @param args Not used
     */
    public static void main(String[] args) {
        // Create two Candidate objects
        Candidate tim = new Candidate("Tim", "Independent");
        Candidate mike = new Candidate("Mike", "Democrat");

        // Print out each candidate's name, party, and vote count 
        // on their own lines
        System.out.println(tim.getName());
        System.out.println(tim.getParty());
        System.out.println(tim.getVotes());
        System.out.println(mike.getName());
        System.out.println(mike.getParty());
        System.out.println(mike.getVotes());

        // Change the party of one candidate, and incremeent 
        // votes twice
        tim.setParty("Republican");
        tim.incrementVotes();
        tim.incrementVotes();

        // Print tim's name, party, and voteCount again
        System.out.println(tim.getName());
        System.out.println(tim.getParty());
        System.out.println(tim.getVotes());

        // TESTING THE ELECTION
        System.out.println("***** Election Test*****\n");

        // Create two election objects and store in two different variables
        Election mayor = new Election();
        Election ceo = new Election();

        // Runs the election on both variables
        System.out.println("\n** MAYOR ELECTION **\n");
        Scanner scan = new Scanner(System.in);
        mayor.runElection(scan);
        System.out.println("\n** CEO ELECTION **\n");
        ceo.runElection(scan);
        scan.close();
    }
}
