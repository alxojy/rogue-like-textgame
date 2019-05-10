package game;

/**
 * This class represents an enemy, Ninja who is also an actor
 * @author Team Kimchi
 */
public class Ninja extends Enemy {

    /**
     * Constructor.
     *
     * Ninjas have 50 hitPoints and are always represented with a 'n'.
     * Constructor calls addBehaviour to add StunBehaviour which stuns the player.
     *
     * @param name Name of the Ninja object
     * @param player Player in the game
     */
    public Ninja(String name, GamePlayer player) {
        super(name, 'n', 4, 50, player);
        addBehaviour(new StunBehaviour(player));
    }
}
