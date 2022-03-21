///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    ElectionTester.java
// File:               Candidate.java
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

public class Candidate {
    private String name;
    private String party;
    private int voteCount;

    public Candidate(String candidateName, String candidateParty) {
        this.name = candidateName;
        this.party = candidateParty;
        this.voteCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getParty() {
        return this.party;
    }

    public int getVotes() {
        return this.voteCount;
    }

    public void setParty(String newParty) {
        this.party = newParty;
    }

    public void incrementVotes() {
        this.voteCount++;
    }
}
