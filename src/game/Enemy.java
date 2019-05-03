package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

/**
 * This abstract class is used as a template for Enemy subclasses
 */
public abstract class Enemy extends Actor {

    private GameMap map;
    private List<ActionFactory> actionFactories = new ArrayList<>();
    private Random rand = new Random();

    Enemy(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
        addItemToInventory(createKey());
    }

    /**
     * Adds the behaviour of an Enemy's subclasses' objects into a List of behaviours
     *
     * @param behaviour the behaviour to be added
     */
    protected void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * The playTurn method iterates through the List of behaviours and returns the first Action behaviour that is not null.
     * If there are no behaviours or the behaviours are null, it iterates through actions. The Action in actions cannot be
     * instances of DropItemAction, TalkAction
     *
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

        Action action = actions.get(rand.nextInt(actions.size()));

        boolean flag = true;
        while (flag) {
            if (!(action instanceof DropItemAction) && !(action instanceof TalkAction)) {
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
