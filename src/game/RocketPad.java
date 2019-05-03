package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

/**
 * Class representing a RocketPad terrain
 */
public class RocketPad extends Ground {
    Item rocketBody = null, rocketEngine= null ;

    /**
     * Constructor
     */
    public RocketPad() {
        super('^');
    }

    /**
     * Returns an action list that can be execute when actor is adjacent to rocketPad
     * BuildRocketAction will only be added to the action list if checItem(location) returns TRUE
     *
     * overrides Ground.getAllowableActions()
     *
     * @param actor the Actor acting
     * @param location the current Location of Rocket Pad
     * @param direction the direction of the Ground from the Actor
     * @return an action list
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();


        if (actor instanceof GamePlayer) {
            if (checkItems(location)) {
                actions.add(new BuildRocketAction(actor,location, rocketBody, rocketEngine));
                ((GamePlayer) actor).removePlayerFromMap((GamePlayer)actor);

            }
        }
        return actions;
    }

    /**
     * Checks if both rocketBody item and rocketEngine item is on the rocketPad
     * @param location location of the rocketPad
     * @return True if and only if both items are present on the rocketPad
     */
    public boolean checkItems(Location location){
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
