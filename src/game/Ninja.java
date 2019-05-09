package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an enemy, Ninja who is also an actor
 * @author Team Kimchi
 */
public class Ninja extends Enemy {

    /**
     * Ninja has 50 hitPoints and are always represented with a 'n'
     * Constructor calls addBehaviour to add StunBehaviour which stuns the player
     *
     * @param name name of the Ninja object
     * @param player player in the game
     */
    public Ninja(String name, Actor player) {
        super(name, 'n', 4, 50);
        addBehaviour(new StunBehaviour(this, player));
        addItemToInventory(new WeaponItem("stun powder bag", 's', 5, "stuns"));
    }
}
