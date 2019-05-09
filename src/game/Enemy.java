package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

/**
 * This abstract class is used as a template for Enemy subclasses
 * @author Team Kimchi
 */
public abstract class Enemy extends Actor {

    private GameMap map;
    /**
     * A List used to store behaviours of the enemy
     */
    private List<ActionFactory> actionFactories = new ArrayList<>();
    private Random rand = new Random();

    /**
     * Constructor.
     * Adds an Item key into an enemy's inventory when instantiated.
     *
     * @param name name of the enemy
     * @param displayChar display character of the enemy
     * @param priority priority of the enemy
     * @param hitPoints the enemy's hitPoints
     */
    Enemy(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
        addItemToInventory(createKey());
    }

    /**
     * Adds the behaviour of an enemy into a List of behaviours
     *
     * @param behaviour the behaviour to be added
     */
    protected void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * The playTurn method iterates through the List of behaviours and returns the first Action behaviour that is not null.
     * If there are no behaviours or the behaviours are null, it iterates through actions. The Action in actions cannot be
     * instances of DropItemAction and PickUpItemAction
     *
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        this.map = map;
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null) {
                return action;
            }
        }

        // get a random Action in actions
        Action action = actions.get(rand.nextInt(actions.size()));

        boolean flag = true;
        while (flag) {
            // checking to ensure that the Action is not an instance of DropItemAction and PickUpItemAction
            if (!(action instanceof DropItemAction) && !(action instanceof PickUpItemAction)) {
                flag = false;
            }
            else {
                action = actions.get(rand.nextInt(actions.size()));
            }
        }
        return action;
    }

    /**
     * Creates a key item by instantiating a new Item object that represents a key in the game
     * The key has a skill GameSkills.UNLOCKDOOR
     *
     * @return an Item key, that has skill GameSkills.UNLOCKDOOR
     */
    private Item createKey() {
        Item key = Item.newInventoryItem("key", 'K');
        key.addSkill(GameSkills.UNLOCKDOOR);
        return key;
    }

}
