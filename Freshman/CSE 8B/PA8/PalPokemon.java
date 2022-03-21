///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               PalPokemon.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Instructor's Name:  Gregory Miranda
//
/**
 * Pokemon that we have in our possession (friendly)
 * @author Matthew Vandenberg
 */
public class PalPokemon extends Pokemon {
    String pokeballName;

    /**
     * Construct a Pal Pokemon without any parameters
     */
    public PalPokemon() {
        super();
        this.pokeballName = "undefined";
    }

    /**
     * Construct a PalPokemon
     * @param pokemonName Name of Pokemon
     * @param pokemonSound Sound of Pokemon
     * @param pokemonType Type of Pokemon
     * @param pokeballName Name of Pokeball
     */
    public PalPokemon(String pokemonName, String pokemonSound, String pokemonType, String pokeballName) {
        super(pokemonName, pokemonSound, pokemonType);
        this.pokeballName = pokeballName;
    }

    /**
     * Get pokeball name
     * @return Pokeball name
     */
    public String getPokeballName() {
        return pokeballName;
    }

    /**
     * Enacting a comes out from pokeball
     */
    public void comesOutFromBall() {
        System.out.printf("%s in %s, %s type pokemon.\n", name, pokeballName, type);
        speak();
    }

    @Override
    /**
     * String representation of PalPokemon
     */
    public String toString() {
        return String.format("%s, PalPokemon\npokeballName: %s\ntype: %s\n", name, pokeballName, type);
    }
}
