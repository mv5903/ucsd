///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    ElectionTester.java
// File:               Election.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       Not used
// Email:              NA
// Instructor's Name:  NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:         NA
//
// Online sources:   NA
//////////////////////////// 80 columns wide //////////////////////////////////

package PA2;

import java.util.Scanner;

public class Election {
    private Candidate candidate1;
    private Candidate candidate2;
    private Candidate candidate3;

    public Election() {
        candidate1 = new Candidate("Matthew", "Independent");
        candidate2 = new Candidate("Michael", "Democrat");
        candidate3 = new Candidate("Shari", "Republican");
    }

    /**
     * Runs the election
     * @param scan Scanner to use for user input
     */
    public void runElection(Scanner scan) {
        // Print out all candidates
        System.out.println("Welcome to the election. We have 3 candidates: \n"
        + "1. " + candidate1.getName() + " from the " + candidate1.getParty() 
        + " party\n"
        + "2. " + candidate2.getName() + " from the " + candidate2.getParty() 
        + " party\n"
        + "3. " + candidate3.getName() + " from the " + candidate3.getParty() 
        + " party\n"
        );

        // Receive votes for each candidate via a System.in Scanner which gets
        // user input
        int voteChoice = 0;
        while (voteChoice != -1) {
            System.out.println("Enter a vote by typing the number of the" 
             + "respective candidate. Type -1 when finished voting.");
            voteChoice = scan.nextInt();
            if (voteChoice == 1) {
                candidate1.incrementVotes();
            } else if (voteChoice == 2) {
                candidate2.incrementVotes();
            } else if (voteChoice == 3) {
                candidate3.incrementVotes();
            }
        }

        // Print out election results
        System.out.println("Final Vote Count: ");
        System.out.println(candidate1.getName() + ": " 
        + candidate1.getVotes());
        System.out.println(candidate2.getName() + ": " 
        + candidate2.getVotes());
        System.out.println(candidate3.getName() + ": " 
        + candidate3.getVotes());
        
        // Determine who wins based on vote counts.
        // Check for three way tie first
        if (candidate1.getVotes() == candidate2.getVotes() 
            && candidate2.getVotes() == candidate3.getVotes()) {

            System.out.println("Wow! There's been a three way tie!");
        }

        // Check for any tie between two of the candidates
        Candidate mostVotes = candidate1;
        if (candidate2.getVotes() > mostVotes.getVotes()) {
            mostVotes = candidate2;
        }
        if (candidate3.getVotes() > mostVotes.getVotes()) {
            mostVotes = candidate3;
        }
        
        // Now that we have a highest count, ensure there's no ties
        if (candidate1.getVotes() == mostVotes.getVotes() 
            && candidate1.getName() != mostVotes.getName()) {

            System.out.println(mostVotes.getName() + " and " 
            + candidate1.getName() + " tie for the win!");
        } else if (candidate2.getVotes() == mostVotes.getVotes() 
            && candidate2.getName() != mostVotes.getName()) {

            System.out.println(mostVotes.getName() + " and " 
            + candidate2.getName() + " tie for the win!");
        } else if (candidate3.getVotes() == mostVotes.getVotes() 
            && candidate3.getName() != mostVotes.getName()) {

            System.out.println(mostVotes.getName() + " and " 
            + candidate3.getName() + " tie for the win!");
        } else {
            // If all else fails, we can finally assume that there's only one 
            // winner:
            System.out.println("The winner is " + mostVotes.getName() + "!");
        }

        
        
    }
}
