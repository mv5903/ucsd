///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA6.java
// File:               RedditDataPoint.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       None
// Email:              NA
// Instructor's Name:  NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None
//
// Online sources:   None
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * RedditDataPoint class
 * @author: Matthew Vandenberg
 * Date: 14 Feb 2022
 */
public class RedditDataPoint {

    private String name = "";
    private String text = "";
    private double lex_liwc_i = 0.0;
    private double lex_liwc_we = 0.0;
    private double lex_liwc_shehe = 0.0;
    
    /**
     * Constructor for Reddit Data Point
     * @param name Subreddit name
     * @param text Subreddit post text
     * @param lex_liwc_i I pronoun count
     * @param lex_liwc_we We pronoun count
     * @param lex_liwc_shehe Third person pronoun count
     */
    public RedditDataPoint(String name, String text, double lex_liwc_i, 
    double lex_liwc_we, double lex_liwc_shehe) {
        this.name = name;
        this.text = text;
        this.lex_liwc_i = lex_liwc_i;
        this.lex_liwc_we = lex_liwc_we;
        this.lex_liwc_shehe = lex_liwc_shehe;
    }

    /**
     * Gets the name of the RedditDataPoint subreddit
     * @return Name of Subreddit
     */
    public String getName(){
       return this.name;
    }

    /**
     * Gets the text content of Reddit post
     * @return Text content
     */
    public String getText(){
        return this.text;
    }

    /**
     * Gets the I pronoun count
     * @return I Pronoun Count
     */
    public double getLexLiwcI() {
        return this.lex_liwc_i;
    }

    /**
     * Gets the we pronoun count
     * @return We pronoun count
     */
    public double getLexLiwcWe() {
        return this.lex_liwc_we;
    }

    /**
     * Gets the third person pronoun count
     * @return Third person pronoun count
     */
    public double getLexLiwcShehe() {
        return this.lex_liwc_shehe;
    }
}