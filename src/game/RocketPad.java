package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

/**
 * Class representing a rocket pad terrain
 * @author Team Kimchi
 */
public class RocketPad extends Ground {

    /**
     * Represents Item objects- rocket body and rocket engine respectively
     */
    private Item rocketBody, rocketEngine;

    /**
     * Constructor.
     *
     * Initialises the char to display for a locked door as 'X'.
     */
    public RocketPad() {
        super('X');
    }

    /**
     * Returns a list of actions that can be performed when the actor is adjacent to the rocket pad.
     * If the location contains a rocket body and a rocket engine, the actor is allowed to build a rocket,
     * A newly instantiated BuildRocketAction is added into a list of action. This allows the actor to execute
     * this action.
     *
     * @param actor the Actor adjacent to the rocket pad
     * @param location the current Location of rocket pad
     * @param direction the direction of the Ground from the Actor
     * @return BuildRocketAction if the location have rocket body and rocket engine.
     * An empty Action list if the location do not have the required items.
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();

        if (checkItems(location)) {
            actions.add(new BuildRocketAction(actor,location, rocketBody, rocketEngine));
        }
        return actions;
    }

    /**
     * Checks if both rocket body and rocket engine are on the rocket pad.
     *
     * @param location location of the rocket pad
     * @return true if and only if both items are present on the rocket pad.
     * false if either or both items are not present.
     */
    private boolean checkItems(Location location){
        boolean bothItemsFound = false;
        List<Item> itemList = location.getItems();
        boolean rBodyFound = false, rEngineFound = false;

        for (Item currentItem : itemList) {
            if (currentItem.hasSkill(GameSkills.BUILDROCKETBASE)) {
                rBodyFound = true;
                rocketBody = currentItem;
            }
            else if (currentItem.hasSkill(GameSkills.BUILDROCKETTOP)) {
                rEngineFound = true;
                rocketEngine = currentItem;
            }
        }
        if (rBodyFound && rEngineFound) {
            bothItemsFound = true;
        }
        return bothItemsFound;
    }
}
