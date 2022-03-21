///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               WildPokemon.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Instructor's Name:  Gregory Miranda
//
/**
 * WildPokemon that we find out in the wild
 * @author Matthew Vandenberg
 */
public class WildPokemon extends Pokemon {
    private int patience;
    private int speed;
    private int timesEscapedFromBall;

    /**
     * Construct a wild pokemon
     */
    public WildPokemon() {
        super();
        this.patience = 100;
        this.speed = 0;
        this.timesEscapedFromBall = 0;
    }

    /**
     * Construct a Wild pokemon
     * @param pokemonName Name of pokemon
     * @param pokemonSound Sound of pokemon
     * @param pokemonType Type of pokemon
     * @param patienceIn Patience of pokemon
     * @param speedIn Speed of pokemon
     */
    public WildPokemon (String pokemonName, String pokemonSound, String pokemonType, int patienceIn, int speedIn) {
        super(pokemonName, pokemonSound, pokemonType);
        this.patience = patienceIn;
        this.speed = speedIn;
        this.timesEscapedFromBall = 0;
    }

    /**
     * Get the patience
     * @return patience
     */
    public int getPatience() {
        return patience;
    }

    /**
     * Get the speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Get the time escaped from ball
     * @return Time escaped from ball
     */
    public int getTimesEscapedFromBall() {
        return timesEscapedFromBall;
    }

    /**
     * Set patience of pokemon
     * @param newPatience Sets patience of pokemon
     */
    public void setPatience(int newPatience) {
        this.patience = newPatience;
    }

    /**
     * Set a new speed of pokemon
     * @param newSpeed Set new speed
     */
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    /**
     * Add one to the time escaped from ball
     */
    public void incrementTimeEscapedFromBall() {
        this.timesEscapedFromBall++;
    }

    /**
     * Enacts a wild pokemon appearance
     */
    public void appear() {
        System.out.println("You encounter a wild " + name + "!");
        speak();
    }

    /**
     * Enacts a disappearance 
     * @return Meets criteria
     */
    public boolean disappear() {
        if (patience <= 0 || timesEscapedFromBall > 3) {
            System.out.println(name + " disappears...");
            return true;
        }
        return false;
    }

    /**
     * Catch the pokemon
     * @param berry Berry to use
     * @param pokeball Pokeball to use
     * @return is it caught
     */
    public boolean isCaught(Berry berry, Pokeball pokeball) {
        return true;
    }

    @Override
    /**
     * String representation of a Wild Pokemon
     */
    public String toString() {
        return String.format("%s, WildPokemon\ntype: %s\npatience: %d\nspeed: %d\ntimeEscapedFromBall: %d\n", name, type, patience, speed, timesEscapedFromBall);
    }
}
