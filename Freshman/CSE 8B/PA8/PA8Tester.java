///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Pokemon Text Implementation
// Files:              PA8Tester.java, Backpack.java, Berry.java, Item.java, 
//                     PalPokemon.java, WildPokemon.java, Pokemon.java, 
//                     Pokedex.java, Pokeball.java
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
// Pair Partner:        NONE
// Email:               NA
// Instructors's Name:  NA
// Lab Section:         NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          NONE
//
// Online sources:   NONE
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * Tests written to check if other classes work as intended
 *
 * Bugs: None known
 *
 */
public class PA8Tester {
    public static void main (String[] args) {
        System.out.println("\n-------------------------------------------\n");

        /* PART 1 */
        
        Pokeball ballOne = new Pokeball();
        Pokeball ballTwo = new Pokeball("Ball", 23);
        System.out.println(ballOne.getName());
        System.out.println(ballOne.getPerformance());
        System.out.println(ballTwo.getName());
        System.out.println(ballTwo.getPerformance());


        System.out.println("\n-------------------------------------------\n");
        
        /* PART 2 */

        Berry berryOne = new Berry("BerryOne", 20, 20);
        Berry berryTwo = new Berry("BerryTwo", 30, 10);
        System.out.println(berryOne.getName());
        System.out.println(berryOne.getPatienceIncrement());
        System.out.println(berryOne.getSpeedDecrement());
        System.out.println(berryTwo.getName());
        System.out.println(berryTwo.getPatienceIncrement());
        System.out.println(berryTwo.getSpeedDecrement());



        System.out.println("\n-------------------------------------------\n");

        /* PART 3 */
        
        PalPokemon pp1 = new PalPokemon("Pikachu", "Pikapika", "Electric", 
        "BallOne");
        PalPokemon pp2 = new PalPokemon("Squirtle", "Squir", "Water",
         "BallTwo");
        System.out.println(pp1.getName());
        System.out.println(pp1.getSound());
        System.out.println(pp1.getType());
        System.out.println(pp1.getPokeballName());
        pp1.comesOutFromBall();
        System.out.println(pp2.getName());
        System.out.println(pp2.getSound());
        System.out.println(pp2.getType());
        System.out.println(pp2.getPokeballName());
        pp2.comesOutFromBall();





        System.out.println("\n-------------------------------------------\n");

        /* PART 4 */

        WildPokemon wp1 = new WildPokemon("Charizard", "char", "fire", 50, 20);
        WildPokemon wp2 = new WildPokemon("Bulbasaur", "bulb", "grass", 50, 5);

        System.out.println(wp1.getName());
        System.out.println(wp1.getPatience());
        System.out.println(wp1.getSound());
        System.out.println(wp1.getSpeed());
        System.out.println(wp1.getTimesEscapedFromBall());
        wp1.appear();
        wp1.disappear();

        System.out.println(wp2.getName());
        System.out.println(wp2.getPatience());
        System.out.println(wp2.getSound());
        System.out.println(wp2.getSpeed());
        System.out.println(wp2.getTimesEscapedFromBall());
        wp2.appear();
        wp2.disappear();



        System.out.println("\n-------------------------------------------\n");

        /* PART 5 */
        
        // TODO1: Create and display the empty backpack
        Backpack backpack = new Backpack();
        backpack.display();

        // TODO2: Add 2 pokeballs that were created in part 1 
        //       to the backpack and display the backpack
        backpack.add(ballOne);
        backpack.add(ballTwo);
        backpack.display();

        // TODO3: Add 2 berries that were created in part 2 
        //       to the backpack and display the backpack
        backpack.add(berryOne);
        backpack.add(berryTwo);
        backpack.display();

        // TODO4: Create an display the empty pokedex
        Pokedex pokedex = new Pokedex();

        // TODO5: Add 2 pal pokemons that were created in part 3
        //        to the pokedex and display the backpack
        pokedex.add(pp1);
        pokedex.add(pp2);
        pokedex.display();

        // TODO6: Add 2 wild pokemons that were created in part 4
        //        to the pokedex and display the backpack
        pokedex.add(wp1);
        pokedex.add(wp2);
        pokedex.display();


        System.out.println(ballTwo + "\n");
        System.out.println(berryTwo + "\n");
        System.out.println(pp2 + "\n");
        System.out.println(wp2);
    }
}
