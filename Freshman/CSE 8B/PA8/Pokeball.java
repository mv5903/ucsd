///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Pokeball.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Instructor's Name:  Gregory Miranda
//
/**
 * Construct a Pokeball, responsible for catching wild pokemon
 * @author Matthew Vandenberg
 */
public class Pokeball extends Item {
    private int performance;

    /**
     * Construct a pokeball
     */
    public Pokeball() {
        super();
        this.performance = 0;
    }

    /**
     * Construct a pokeball
     * @param pokeballName Name of pokeball
     * @param performanceIn Performance type
     */
    public Pokeball(String pokeballName, int performanceIn) {
        super(pokeballName);
        this.performance =  performanceIn;
    }

    /**
     * Get the performance level
     * @return Performance
     */
    public int getPerformance() {
        return performance;
    }

    @Override
    /**
     * String representation of a Pokeball
     */
    public String toString() {
        return String.format("%s\nperformance: %d\n", name, performance);
    }
    
}
