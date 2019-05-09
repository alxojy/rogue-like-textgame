package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 *This class is responsible for the actor performing the action to unlock a door
 * @author Team Kimchi
 */
public class UnlockDoorAction extends Action {

    private String direction;
    private Location doorLocation;

    /**
     * Constructor initialises the direction and location of the locked door
     *
     * @param direction direction of the door relative to the actor
     * @param doorLocation location of the locked door
     */
    UnlockDoorAction(String direction, Location doorLocation) {
        this.direction = direction;
        this.doorLocation = doorLocation;
    }

    /**
     * If the actor's inventory has an item key with the skills GameSkills.UNLOCKDOOR, the key will be removed and
     * the door will be unlocked. The locked door terrain will be replaced with the Floor terrain
     * Overrides Action.execute()
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String describing that the door has been unlocked
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
     * Returns a String describing the action suitable for displaying in the menu, which is unlocks a door
     *
     * @param actor The actor performing the action.
     * @return  a String describing the unlock door action
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
