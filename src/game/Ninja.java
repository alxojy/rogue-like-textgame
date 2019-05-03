package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an enemy, Ninja
 */
public class Ninja extends Enemy {

    /**
     * Ninja has 50 hitPoints and are always represented with a 'n'
     * Calls addBehaviour in the constructor to add StunBehaviour which stuns the player
     *
     * @param name name of the Ninja object
     * @param player player in the game
     */
    public Ninja(String name, Actor player) {
        super(name, 'n', 5, 50);
        addBehaviour(new StunBehaviour(this, player));
    }
}
