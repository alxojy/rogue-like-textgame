package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class represents an actor who is a researcher called Doctor Maybe
 * @author Team Kimchi
 */
public class DrMaybe extends Actor {

    private GamePlayer player;

    /**
     * Constructor.
     *
     * Uses Grunt class's static variable to get half of Grunt's hitPoints.
     *
     * @param name The name of the DrMaybe actor.
     * @param player The player in the game which is its target.
     */
    DrMaybe(String name, GamePlayer player) {
        super(name, 'm', 6, Grunt.GRUNT_HITPOINTS/2);
        this.player = player;
        addItemToInventory(createRocketEngine());
    }

    /**
     * The overridden playTurn method returns a suitable Action for the DrMaybe object to perform.
     *
     * It calls the Distance class's isAdjacent method to check if the player is adjacent to it.
     * It attacks the player if its adjacent to it. Else, it does nothing.
     *
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return A newly instantiated AttackAction if the player is adjacent to the DrMaybe object. Else,
     * a newly instantiated SkipTurnAction.
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        Location drMaybeLocation = map.locationOf(this);
        if (Distance.isAdjacent(drMaybeLocation, player)) {
            return new AttackAction(this, player);
        }
        return new SkipTurnAction();
    }

    /**
     * Creates a rocket engine item.
     *
     * Instantiates a new Item object that represents a rocket engine in the game.
     * The rocket engine has a skill GameSkills.BUILDROCKETBASE
     *
     * @return An Item that represents a rocket engine
     */
    private Item createRocketEngine() {
        Item rocketEngine = Item.newInventoryItem("rocket engine", 'e');
        rocketEngine.addSkill(GameSkills.BUILDROCKETBASE);
        return rocketEngine;
    }

    /**
     * Creates an intrinsic weapon which throws a conical flask.
     *
     * Uses Grunt class's static variable to get half of Grunt's damage.
     *
     * @return a newly instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(Grunt.GRUNT_DAMAGE/2, "throws a conical flask at");
    }
}
