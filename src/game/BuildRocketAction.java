package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * This class represents an action that builds a rocket
 * @author Team Kimchi
 */

public class BuildRocketAction extends Action {

    private Actor subject;
    private Location location;
    /**
     * Represents 
     */
    private Item rocketBody, rocketEngine;


    /**
     * Constructor
     *
     * @param actor the actor that is executing this action
     * @param location the location of the rocket pad
     * @param rocketBody the rocket body item that is on the rocket pad
     * @param rocketEngine the rocket engine item that is on the rocket pad
     */
    BuildRocketAction(Actor actor, Location location, Item rocketBody, Item rocketEngine) {
        this.location = location;
        this.rocketBody = rocketBody;
        this.rocketEngine = rocketEngine;
        subject = actor;
    }

    /**
     * Performs the action of building a rocket.
     * Overrides its superclass's execute method and performs the following tasks:
     * 1. replaces the rocket pad with a rocket
     * 2. removes rocket body and rocket engine from the rocket pad
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing that the rocket has been created.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.addItem(createRocket(),location.x(),location.y());
        location.removeItem(rocketBody);
        location.removeItem(rocketEngine);
    
        return "Rocket has been created";
    }
    /**
     * Returns a description of the build rocket action to display on the menu.
     *
     * @param actor The actor performing the build rocket action.
     * @return a String of text about the build rocket action to display on the menu.
     */
    @Override
    public String menuDescription(Actor actor) {
        return subject + " creates a rocket";
    }

    /**
     * Returns the empty String, as no hotKey is permanently assigned to BuildRocketAction.
     *
     * @return the empty String
     */
    @Override
    public String hotKey() {
        return "";
    }

    /**
     * Creates a rocket item
     *
     * @return a newly instantiated Item object that represents a rocket
     */
    private Item createRocket() {
        return Item.newFurniture("rocket", '^');
    }
}
