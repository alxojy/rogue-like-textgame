package game;
import edu.monash.fit2099.engine.*;

/**
 * This class represents a locked door
 * @author Team Kimchi
 */
public class LockedDoor extends Ground {

    /**
     * Constructor.
     *
     * Initialises the char to display for a locked door as '+'.
     */
    public LockedDoor() {
        super('+');
    }

    /**
     * Locked door is an impassable terrain.
     *
     * @param actor Actor adjacent to the locked door
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) { return false; }

    /**
     * Returns a list of actions that can be performed when the actor is adjacent to the locked door.
     * If the actor contains a key item in their inventory, they are allowed to unlock the door, which calls for the
     * UnlockDoorAction class.
     *
     * @param actor the Actor adjacent to the locked door
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return UnlockDoorAction if the player has the key. An empty Action list if the player does not have the key
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        if (containsKey(actor)) {
            actions.add(new UnlockDoorAction(location));
        }
        return actions;
    }

    /**
     * The locked door terrain blocks thrown objects.
     *
     * @return true
     */
    @Override
    public boolean blocksThrownObjects() {
        return true;
    }

    /**
     * Checks if the actor's inventory has a key item that has skill GameSkills.UNLOCKDOOR
     *
     * @param actor adjacent to the door
     * @return true if the actor's inventory has the key with GameSkills.UNLOCKDOOR. false otherwise
     */
    private boolean containsKey(Actor actor) {
        for (Item currentItem : actor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.UNLOCKDOOR)) {
                return true;
            }
        }
        return false;
    }

}
