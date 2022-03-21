///////////////////////////////////////////////////////////////////////////////
// Main Class File:    BarChartRacer.java
// File:               BarChartRacer.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
// NO HELP OR PAIR PROGRAMMING USED
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Driver to create a video/multiple BarCharts successively and display
 * them to the user.
 * Run command: java BarChartRacer <input_file> <num entries per chart>
 * For example: java BarChartRacer cities-usa.txt 10
 *
 * Bugs: None known
 *
 * @author Matthew Vandenberg
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.io.*;

public class BarChartRacer {

    // a tracker for the year/date of the current chunk
    private static String caption;

    /**
     * Get all bars from a particular chunk
     * @param in Scanner to use containing ability to read file
     * @return ArrayList of bars
     */
    private static ArrayList<Bar> getBars(Scanner in) {
        ArrayList<Bar> bars = new ArrayList<Bar>();
        Scanner reader = in;
        reader.nextLine();
        int numRowsInChunk = Integer.parseInt(reader.nextLine());
        for (int i = 0; i < numRowsInChunk; i++) {
            String nextLine = reader.nextLine();
            String[] args = nextLine.split(",");
            if (i == 0) caption = args[0]; 
            System.out.println(args[0]); 
            Bar bar = new Bar(args[1], Integer.parseInt(args[3]), args[2]);
            bars.add(bar);
        }
        return bars;
    }

    /**
     * Create the chart
     * @param chart BarChart to use
     * @param bars data to use for chart
     * @param numEntries amount of entries to include
     */
    private static void createChart(BarChart chart, ArrayList<Bar> bars, int numEntries) {
        if (numEntries > bars.size()) {
            System.out.println("Error: numEntries greater than bars.size()!");
            return;
        }
        chart.setCaption(caption);
        for (int i = 0; i < numEntries; i++) {
            Bar bar = bars.get(i);
            chart.add(bar.getName(), bar.getValue(), i);
        }
    }

    /**
     * Create a bar chart here
     * @param args 0: name of file, 1: numEntries
     * @throws FileNotFoundException File does not exist
     */
    public static void main(String[] args) throws FileNotFoundException {

        // do not modify these two lines
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        System.out.println(java.util.Arrays.toString(args));
        Scanner reader = new Scanner(new File(args[0]));
        BarChart chart = new BarChart(reader.nextLine(), reader.nextLine(), reader.nextLine());
        
        while (reader.hasNextLine()) {
            System.out.println("Next line");
            ArrayList<Bar> barsList = getBars(reader);
            Collections.sort(barsList);
            Collections.reverse(barsList);
            createChart(chart, barsList, Integer.parseInt(args[1]));
            chart.draw();
            StdDraw.show();
            StdDraw.pause(1);
            chart.reset();
        }
        
        reader.close();

    
        // do not modify these lines
        // clear and redraw chart (you need to do this for every graph you create)
        chart.draw(); // here chart is your BarChart object
        StdDraw.show();
        StdDraw.pause(1);
        chart.reset(); // here chart is your BarChart object
    }
}
