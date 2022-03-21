///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA6
// Files:              PA6.java, RedditDataPoint.java
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
// Pair Partner:        None
// Email:               NA
// Instructors's Name:  NA
// Lab Section:         NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          None
//
// Online sources:   None
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;
import java.io.*;
import java.util.*;

/**
 * PA6, manipulating data with ArraysLists for reddit posts
 */
public class PA6 {
    // PROVIDED CONSTANT
    private static final String DELIMITER = ","; // CSV file delimiter
    private static final int NAME_INDEX = 0; // A
    private static final int TEXT_INDEX = 114; // DK
    private static final int LEX_LIWC_I_INDEX = 19; // T
    private static final int LEX_LIWC_WE_INDEX = 20; // U
    private static final int LEX_LIWC_SHEHE_INDEX = 22; // W

    /**
     * Read data from a csv file
     * @param fileName Name of file to read from
     * @param categories Unique category names
     * @return RedditDataPoints
     * @throws IOException Thrown if file does not exists
     */
    public static ArrayList<RedditDataPoint> readData(String fileName, 
    ArrayList<String> categories) throws IOException {
        // Create new ArrayList to store the data from the file
        ArrayList<RedditDataPoint> data = new ArrayList<RedditDataPoint>();
        // BufferedReader for assistance reading each line
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String nextLine = "";
        while (true) {
            nextLine = reader.readLine();
            if (nextLine == null) break;
            String[] lineAsArray = nextLine.split(DELIMITER);
            // First Line
            if (lineAsArray[0].equals("subreddit")) continue;
            // Create new RedditDataPoint with corresponding values from each
            data.add(new RedditDataPoint(
                lineAsArray[NAME_INDEX],
                lineAsArray[TEXT_INDEX],
                Double.parseDouble(lineAsArray[LEX_LIWC_I_INDEX]),
                Double.parseDouble(lineAsArray[LEX_LIWC_WE_INDEX]),
                Double.parseDouble(lineAsArray[LEX_LIWC_SHEHE_INDEX])
            ));

            // Add to subreddit list, if not already existent in list
            if (!categories.contains(lineAsArray[NAME_INDEX])) {
                categories.add(lineAsArray[NAME_INDEX]);
            }
        }

        return data;
    }

    /**
     * Prints the total number of posts from each subreddit
     * @param data Data to read
     * @param categories Categories
     */
    public static void printTotalPosts(ArrayList<RedditDataPoint> data, 
    ArrayList<String> categories) {
        // "[subreddit]:[count]"
        List<String> postsAndSubs = new ArrayList<String>();
        // Go through each data point. If that point exists in the list,
        //  simply add 1.
        // Otherwise, create a new point in the list.
        for (RedditDataPoint rdp: data) {
            String itemToReplace = "", replacement = "";
            boolean itemExists = false;
            for (String dataPoint: postsAndSubs) {
                if (dataPoint.contains(rdp.getName())) {
                    // Split into array, where "[subreddit]:[count]"
                    String[] arr = dataPoint.split(":");
                    // Add one to the count
                    arr[1] = Integer.toString(Integer.parseInt(arr[1]) + 1);
                    // Recreate the string for the list
                    replacement = String.join(":", arr);
                    // Mark this datapoint for replacement.
                    itemToReplace = dataPoint;
                    // Used to see if the item exists already
                    itemExists = true;
                    break;
                }
            }
            if (itemExists) {
                postsAndSubs.remove(itemToReplace);
                postsAndSubs.add(replacement);
            } else {
                postsAndSubs.add(rdp.getName() + ":1");
            }
        }

        for (String point: postsAndSubs) {
            String[] subreddit = point.split(":");
            System.out.println("r/" + subreddit[0] + " total posts: " 
            + subreddit[1]);
        }
    }

    /**
     * Prints the total amount of I pronouns used in each post
     * @param data Data to read
     * @param categories Categories
     */
    public static void printTotalLexLiwcI(ArrayList<RedditDataPoint> data,
     ArrayList<String> categories) {
        List<String> subs = new ArrayList<String>();
        // Go through each data point. If that point exists in the list,
        // simply add 1.
        // Otherwise, create a new point in the list.
        for (RedditDataPoint rdp: data) {
            String itemToReplace = "", replacement = "";
            boolean itemExists = false;
            for (String dataPoint: subs) {
                if (dataPoint.contains(rdp.getName())) {
                    // Split into array, where "[subreddit]:[lexwici]"
                    String[] arr = dataPoint.split(":");
                    // Add one to the count
                    arr[1] = Integer.toString(Integer.parseInt(arr[1]) + 1);
                    // Recreate the string for the list
                    replacement = String.join(":", arr);
                    // Mark this datapoint for replacement.
                    itemToReplace = dataPoint;
                    // Used to see if the item exists already
                    itemExists = true;
                    break;
                }
            }
            if (rdp.getLexLiwcI() > 0) {
                if (itemExists) {
                    subs.remove(itemToReplace);
                    subs.add(replacement);
                } else {
                    subs.add(rdp.getName() + ":1");
                }
            }
        }

        for (String point: subs) {
            String[] subreddit = point.split(":");
            System.out.println("r/" + subreddit[0] + " total lex_liwc_i: "
             + subreddit[1]);
        }
    }

    /**
     * Prints the total amount of times that a we pronoun is used
     * @param data Data to read
     * @param categories Categories
     */
    public static void printTotalLexLiwcWe(ArrayList<RedditDataPoint> data,
     ArrayList<String> categories) {
        List<String> subs = new ArrayList<String>();
        // Go through each data point. If that point exists in the list,
        // simply add 1.
        // Otherwise, create a new point in the list.
        for (RedditDataPoint rdp: data) {
            String itemToReplace = "", replacement = "";
            boolean itemExists = false;
            for (String dataPoint: subs) {
                if (dataPoint.contains(rdp.getName())) {
                    // Split into array, where "[subreddit]:[lelxwicwe]"
                    String[] arr = dataPoint.split(":");
                    // Add one to the count
                    arr[1] = Integer.toString(Integer.parseInt(arr[1]) + 1);
                    // Recreate the string for the list
                    replacement = String.join(":", arr);
                    // Mark this datapoint for replacement.
                    itemToReplace = dataPoint;
                    // Used to see if the item exists already
                    itemExists = true;
                    break;
                }
            }
            if (rdp.getLexLiwcWe() > 0) {
                if (itemExists) {
                    subs.remove(itemToReplace);
                    subs.add(replacement);
                } else {
                    subs.add(rdp.getName() + ":1");
                }
            }
        }

        for (String point: subs) {
            String[] subreddit = point.split(":");
            System.out.println("r/" + subreddit[0] + " total lex_liwc_we: " 
            + subreddit[1]);
        }
    }

    /**
     * Prints the total amount of times a third-person pronoun is used 
     * for each subreddit
     * @param data Data to read
     * @param categories Categories
     */
    public static void printTotalLexLiwcShehe(ArrayList<RedditDataPoint> data,
     ArrayList<String> categories) {
        List<String> subs = new ArrayList<String>();
        // Go through each data point. If that point exists in the list, simply add 1.
        // Otherwise, create a new point in the list.
        for (RedditDataPoint rdp: data) {
            String itemToReplace = "", replacement = "";
            boolean itemExists = false;
            for (String dataPoint: subs) {
                if (dataPoint.contains(rdp.getName())) {
                    // Split into array, where "[subreddit]:[lexlwicshehe]"
                    String[] arr = dataPoint.split(":");
                    // Add one to the count
                    arr[1] = Integer.toString(Integer.parseInt(arr[1]) + 1);
                    // Recreate the string for the list
                    replacement = String.join(":", arr);
                    // Mark this datapoint for replacement.
                    itemToReplace = dataPoint;
                    // Used to see if the item exists already
                    itemExists = true;
                    break;
                }
            }
            if (rdp.getLexLiwcShehe() > 0) {
                if (itemExists) {
                    subs.remove(itemToReplace);
                    subs.add(replacement);
                } else {
                    subs.add(rdp.getName() + ":1");
                }
            }
        }

        for (String point: subs) {
            String[] subreddit = point.split(":");
            System.out.println("r/" + subreddit[0] + " total lex_liwc_shehe: " 
            + subreddit[1]);
        }
    }

    /*
     * Starpoint OPTIONAL
     */
    public static void printStarPointAverage(ArrayList<RedditDataPoint> data,
     ArrayList<String> categories) {

    }

    /**
     * Prints all of the data out for the project
     * @param args Not used
     * @throws IOException If provided filename does not exist
     */
    public static void main(String args[]) throws IOException {
        try {
            ArrayList<String> categories = new ArrayList<String>();
            ArrayList<RedditDataPoint> data = 
            readData("Reddit_Data.csv", categories);
            System.out.println("\nTotal Posts");
            printTotalPosts(data, categories);
            System.out.println("\nTotal lexLiwcI");
            printTotalLexLiwcI(data, categories);
            System.out.println("\nTotal lexLiwcWe");
            printTotalLexLiwcWe(data, categories);
            System.out.println("\nTotal lexLiwcShehe");
            printTotalLexLiwcShehe(data, categories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}