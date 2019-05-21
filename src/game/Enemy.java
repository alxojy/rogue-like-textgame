package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

/**
 * This abstract class is used as a template for Enemy subclasses.
 * It is not meant to be instantiated as it does not represent any specific enemy in the game.
 * @author Team Kimchi
 */
public abstract class Enemy extends Actor {

    private GameMap map;

    /**
     * A List used to store behaviours of the enemy
     */
    private List<ActionFactory> actionFactories = new ArrayList<>();
    private Actor subject;

    /**
     * Constructor.
     *
     * Adds an Item key into an enemy's inventory when instantiated.
     *
     * @param name Name of the enemy.
     * @param displayChar Display character of the enemy.
     * @param priority Priority of the enemy.
     * @param hitPoints The enemy's hit points.
     * @param player The player in the game which is its target.
     */
    Enemy(String name, char displayChar, int priority, int hitPoints, Actor player) {
        super(name, displayChar, priority, hitPoints);
        subject = player;
        addItemToInventory(createKey());
    }

    /**
     * Adds the behaviour of an enemy into a List of behaviours.
     *
     * @param behaviour The behaviour to be added
     */
    protected void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * Returns a suitable Action for the enemy to perform.
     *
     * The playTurn method iterates through the List of behaviours and returns the first Action behaviour
     * that is not null.
     * If there are no behaviours or the behaviours are null, it checks it is adjacent to the player.
     * If it is adjacent to the player, it will return an AttackAction. Else, it will do nothing.
     *
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return A suitable Action to perform.
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

        Location enemyLocation = map.locationOf(this);
        if (Distance.isAdjacent(enemyLocation, subject)) {
                return new AttackAction(this, subject);
            }
        return new SkipTurnAction();
    }

    /**
     * Creates an Item key.
     *
     * Instantiates a new Item object that represents a key in the game.
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
