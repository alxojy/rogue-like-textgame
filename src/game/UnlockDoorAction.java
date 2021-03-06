package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class is responsible for the actor performing the action to unlock a door
 * @author Team Kimchi
 */
public class UnlockDoorAction extends Action {

    private Location doorLocation;

    /**
     * Constructor.
     *
     * @param doorLocation location of the locked door
     */
    UnlockDoorAction(Location doorLocation) {
        this.doorLocation = doorLocation;
    }

    /**
     * Performs the action of unlocking a locked door.
     *
     * If the actor's inventory has an Item key with the skills GameSkills.UNLOCKDOOR, the key will be removed from their
     * inventory and the door will be unlocked. The locked door terrain will be replaced with the Floor terrain
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A String describing that the door has been unlocked if actor's inventory contains key item which has
     *         GameSkills.UNLOCKDOOR. Else, returns an empty string
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.add(new Floor(), doorLocation);
            for (Item item : actor.getInventory()) {
                if (item.hasSkill(GameSkills.UNLOCKDOOR)) {
                    actor.removeItemFromInventory(item);
                    return "The door is unlocked";
                }
            }
        return "";
    }

    /**
     * Returns a String describing the Action suitable for displaying in the menu, which is unlocks a door
     *
     * @param actor The actor performing the action.
     * @return A String describing the unlock door action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " unlocks a door";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
