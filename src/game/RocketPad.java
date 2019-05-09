package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

/**
 * Class representing a RocketPad terrain
 * @author Team Kimchi
 */
public class RocketPad extends Ground {
    private Item rocketBody, rocketEngine;

    /**
     * Constructor
     */
    public RocketPad() {
        super('X');
    }

    /**
     * Returns an action list that can be execute when actor is adjacent to rocketPad
     * BuildRocketAction will only be added to the action list if checItem(location) returns TRUE
     *
     * Overrides Ground.getAllowableActions()
     *
     * @param actor the Actor acting
     * @param location the current Location of Rocket Pad
     * @param direction the direction of the Ground from the Actor
     * @return an action list
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
     * Checks if both rocketBody item and rocketEngine item is on the rocketPad
     *
     * @param location location of the rocketPad
     * @return True if and only if both items are present on the rocketPad
     */
    private boolean checkItems(Location location){
        boolean retVal = false;
        List<Item> itemList = location.getItems();
        boolean firstCond = false, secondCond = false;

        for (Item currentItem : itemList) {
            if (currentItem.hasSkill(GameSkills.BUILDROCKETBASE)) {
                firstCond = true;
                rocketBody = currentItem;
            }
            else if (currentItem.hasSkill(GameSkills.BUILDROCKETTOP)) {
                secondCond = true;
                rocketEngine = currentItem;
            }
        }
        if (firstCond && secondCond) {
            retVal = true;
        }
        return retVal;
    }
}
