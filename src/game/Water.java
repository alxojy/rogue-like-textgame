package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents water which is a terrain type
 * @author Team Kimchi
 */
public class Water extends Ground {

    /**
     * Constructor.
     * Initialises the char to display for water as '~'.
     */
    public Water() {
        super('~');
    }

    /**
     * water is an impassable terrain.
     *
     * @param actor Actor adjacent to water
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) { return false; }

    /**
     * Returns a list of actions that can be performed when the actor is adjacent to water.
     * If the actor contains a waterPistol item in their inventory, they are allowed to refill their waterPistol
     * this calls for the FillEmptyPistolAction class.
     *
     * @param actor the Actor adjacent to water
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return FillEmptyPistolAction if the player has the waterPistol.
     *         An empty Action list if the player does not have the waterPistol
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        if (containsPistol(actor)) {
            actions.add(new FillEmptyPistolAction());
        }
        return actions;
    }

    /**
     * Checks if the actor's inventory has a waterPistol item that has skill GameSkills.PISTOLISEMPTY
     *
     * @param actor adjacent to water
     * @return true if the actor's inventory has the waterPistol with GameSkills.PISTOLISEMPTY. false otherwise
     */
    private boolean containsPistol(Actor actor) {
        for (Item currentItem : actor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.PISTOLISEMPTY)) {
                return true;
            }
        }
        return false;
    }
}

