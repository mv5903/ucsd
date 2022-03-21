///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA8Tester.java
// File:               Backpack.java
// Quarter:            CSE 8B Winter 2022
//
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;

/**
 * This is Backpack class that you can add items which are berries and
 * pokeballs. You can display your backpack with display() method
 *
 * Bugs: None known
 * @author : Matthew Vandenberg
 *
 */

public class Backpack {

    // ArrayList for items (berries, pokeballs)
    private ArrayList<Item> myItems;

    /**
     * Creates a resizable-array ArrayLists of Items
     * 
     */
    public Backpack() {
        this.myItems = new ArrayList<Item>();
    }

    /**
     * Adds the item to myItems
     * 
     */
    public void add(Item item) {
        this.myItems.add(item);
    }

    /**
     * Displays the elements in the myItems ArrayList
     * 
     */
    public void display() {
        System.out.println("Items in the backpack: \n");
        if (myItems.size() == 0) {
            System.out.println("None.");
            return;
        }
        for (Item item: myItems) {
            System.out.println(item + "\n");
        }
    }
}
