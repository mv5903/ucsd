///////////////////////////////////////////////////////////////////////////////
// Main Class File:    BarChartRacer.java
// File:               PA7Tester.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
// NO HELP OR PAIR PROGRAMMING USED
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Sample tests to check if other classes work as intended
 *
 * Bugs: None known
 *
 * @author Matthew Vandenberg
 */

import java.util.*;

public class PA7Tester {
    // sample client
    public static void main(String[] args) {

        // Bar Tester (Part 1)
        Bar bar1 = new Bar("New York", 1200, "New York");
        Bar bar2 = new Bar("Ensenada", 1800, "Mexico");
        Bar bar3 = new Bar("Tel Aviv", 1800, "Israel");

        System.out.println("bar1's properties: ");
        System.out.println(bar1.getName() + ", " + bar1.getCategory() + ": " + bar1.getValue() + "\n");
        System.out.println("bar2's properties: ");
        System.out.println(bar2.getName() + ", " + bar2.getCategory() + ": " + bar2.getValue() + "\n");
        System.out.println("bar3's properties: ");
        System.out.println(bar3.getName() + ", " + bar3.getCategory() + ": " + bar3.getValue() + "\n");

        System.out.println("Testing compareTo()");
        System.out.println("bar1.compareTo(bar2): " + bar1.compareTo(bar2));
        System.out.println("bar2.compareTo(bar1): " + bar2.compareTo(bar1));
        System.out.println("bar2.compareTo(bar3): " + bar2.compareTo(bar3));

        // Bar Chart Tester (Part 2)
        BarChart chart = new BarChart("City Populations", "Population", "github");
        chart.setCaption("caption goes here");
        chart.add(bar1.getName(), bar1.getValue(), 0);
        chart.add(bar2.getName(), bar2.getValue(), 1);
        chart.add(bar3.getName(), bar3.getValue(), 2);
        chart.draw();
        chart.reset();

        Bar bar4 = new Bar("Tokyo", 1354, "Japan");
        Bar bar5 = new Bar("Zürich", 4588, "Switzerland");
        Bar bar6 = new Bar("San José", 2000, "Costa Rica");
        BarChart chart2 = new BarChart("Covid Cases", "Cases", "cdc (not really)");
        chart2.setCaption("COVID-19 Cases");
        chart2.add(bar4.getName(), bar4.getValue(), 3);
        chart2.add(bar5.getName(), bar5.getValue(), 4);
        chart2.add(bar6.getName(), bar6.getValue(), 5);
        chart2.draw();

        // // do not modify these two lines
        // StdDraw.setCanvasSize(1000, 700);
        // StdDraw.enableDoubleBuffering();

        // // TODO: Add Bar.java tests

        // // TODO: Add BarChart.java tests

        
        // // TEST 1 
        // // do not modify these lines, otherwise drawing behavior will be weird

        // chart.draw(); // here chart is your BarChart object
        // StdDraw.show(); // you can also use Std.show(1000)/StdDraw.pause() to show for a specified interval
        // chart.reset(); // here chart is your BarChart object

        // // TEST 2
        // // do not modify these lines, otherwise drawing behavior will be weird
        // chart.draw(); // here chart is your BarChart object
        // StdDraw.show(); // you can also use Std.show(1000)/StdDraw.pause() to show for a specified interval
        // chart.reset(); // here chart is your BarChart object

        // // BarChartRacer.java tests can directly be run in it's own main method
        // // once Bar and BarChart work correctly.
    }
}
