package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class represents an actor who is a researcher called Doctor Maybe
 * @author Team Kimchi
 */
public class DrMaybe extends Actor {

    private Actor player;

    /**
     * Constructor.
     * Calls its superclass's constructor to initialise the @param name "Dr Maybe", @param displayChar 'M', priority and hitPoints.
     * When a DrMaybe object is instantiated, a rocket engine item is added to its inventory.
     */
    DrMaybe(String name, Actor player) {
        super(name, 'm', 6, 25);
        this.player = player;
        addItemToInventory(createRocketEngine());
    }

    /**
     *The overridden playTurn method gets a random Action to perform from actions. The Action cannot be an
     * instance of DropItemAction
     *
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        if (new Distance().distance(map.locationOf(player), map.locationOf(this)) == 1) {
            return new AttackAction(this, player);
        }
        return new SkipTurnAction();
    }

    /**
     * Creates a rocket engine item by instantiating a new Item object that represents a rocket engine in the game.
     * The rocket engine has a skill GameSkills.BUILDROCKETBASE
     *
     * @return an Item that represents a rocket engine
     */
    private Item createRocketEngine() {
        Item rocketEngine = Item.newInventoryItem("rocket engine", 'e');
        rocketEngine.addSkill(GameSkills.BUILDROCKETBASE);
        return rocketEngine;
    }

    /**
     * Creates an intrinsic weapon which throws a conical flask.
     *
     * @return a newly instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon((int) (Grunt.GRUNT_DAMAGE*0.5), "throws a conical flask at");
    }
}
