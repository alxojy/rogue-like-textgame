package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * This class represents an action that builds a rocket
 */

public class BuildRocketAction extends Action {

    private Actor subject;
    private Location location ;
    private Item rocketBody , rocketEngine ;


    /**
     * Constructor
     *
     * @param actor the actor that is executing this action
     * @param location the location of the rocket pad
     * @param rocketBody the rocketBody item that is on the given rocketPad
     * @param rocketEngine the rocketEngime item that is on the given rocketPad
     */
    BuildRocketAction(Actor actor,Location location, Item rocketBody, Item rocketEngine) {
        this.location = location;
        this.rocketBody = rocketBody;
        this.rocketEngine = rocketEngine;
        subject = actor;
    }

    /**
     * Overrides Action.execute() and performs the following tasks
     * 1. replaces the rocket pad with a rocket
     * 2. removes rocketBody and rocketEngine from the rocket pad
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing what is executed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.addItem(createRocket(),location.x(),location.y());
        location.removeItem(rocketBody);
        location.removeItem(rocketEngine);
    
        return "Rocket has been created";
    }
    /**
     * Returns a description of this movement suitable to display in the menu.
     *
     * @param actor The actor performing the build rocket action.
     * @return a String
     */
    @Override
    public String menuDescription(Actor actor) {
        return subject + " creates a rocket";
    }

    /**
     * Returns the empty string, as no hotkey is permanently assigned to BuildRocketAction.
     * @return the empty string
     */
    @Override
    public String hotKey() {
        return "";
    }

    /**
     * creates a rocket item
     * @return the rocket item
     */
    private Item createRocket() {
        return Item.newFurniture("rocket", '^');
    }
}
