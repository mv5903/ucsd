///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Berry.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Instructor's Name:  Gregory Miranda
//

/**
 * One of the Pokemon items used to lure WildPokemon
 * 
 * @author Matthew Vandenberg
 */
public class Berry extends Item {
    private int patienceIncrement;
    private int speedDecrement;

    /**
     * Default Constructor
     */
    public Berry() {
        patienceIncrement = 0;
        speedDecrement = 0;
    }

    /**
     * Make a specific Berry
     * @param berryName Name of Berry
     * @param patienceInc Amount of patience
     * @param speedDec Speed Decrement
     */
    public Berry(String berryName, int patienceInc, int speedDec) {
        super(berryName);
        this.patienceIncrement = patienceInc;
        this.speedDecrement = speedDec;
    }

    /**
     * Get the patience increment
     * @return Patience increment
     */
    public int getPatienceIncrement() {
        return patienceIncrement;
    }

    /**
     * Get the speed decrement
     * @return Speed Decrement
     */
    public int getSpeedDecrement() {
        return speedDecrement;
    }

    /**
     * String representation of a Berry
     */
    @Override
    public String toString() {
        return String.format("%s\npatienceIncrement: %d\nspeedDecrement: %d\n", name, patienceIncrement,
                speedDecrement);
    }
}
