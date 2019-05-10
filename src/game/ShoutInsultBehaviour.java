package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class represents the shout insult behaviour and creates an Action for the actor to shout insult to its target
 * @author Team Kimchi
 */
public class ShoutInsultBehaviour extends Action implements ActionFactory {

    private Actor target;
    private Random rand = new Random();

    /**
     * An array of insults
     */
    private static String[] insults = {"That's a bad move...", "This is an abomination!",
            "Did you press the wrong button again?"};

    /**
     * Constructor.
     *
     * @param subject Target actor to be insulted.
     */
    ShoutInsultBehaviour(Actor subject) {
        this.target = subject;
    }

    /**
     * Performs the action of shouting an insult.
     *
     * Randomly chooses an insult from an array of possible insults.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String describing the actor insulting its target and the insult thrown
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int ranNum = rand.nextInt(insults.length);
        String insult = insults[ranNum];
        return actor + " insulted " + target + System.lineSeparator()+
                actor + ": " + insult;
    }

    /**
     * Returns this if successful. Otherwise, return null.
     *
     * There is a 10% chance of the insult being thrown. If successful, return this - shout insult Action.
     * If not, return null.
     *
     * @param actor the actor that shouts the insult
     * @param map the map that the player is on
     * @return this if successful. Otherwise, return null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextDouble() <= 0.10) {
            return this;
        }
        return null;
    }

    /**
     * Returns a String describing the action suitable for displaying in the menu, which is insults.
     *
     * @param actor The actor performing the action.
     * @return An empty String
     */
    @Override
    public String menuDescription(Actor actor) {
        return " insults ";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
