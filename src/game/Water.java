package game;

import edu.monash.fit2099.engine.*;
import game.bonusGame.BonusGameSkills;
import game.bonusGame.FillBucketAction;

/**
 * This class represents water which is a terrain type
 * @author Team Kimchi
 */
public class Water extends Ground {

    /**
     * Constructor.
     *
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
     * @return FillEmptyPistolAction if the player has the water pistol.
     *         An empty Action list if the player does not have the water pistol
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        if (containsPistol(actor)) {
            actions.add(new FillEmptyPistolAction());
        }
        if(containsBucket(actor)) {
            actions.add(new FillBucketAction());
        }
        return actions;
    }

    /**
     * Checks if the actor's inventory has an empty water pistol item that has skill GameSkills.PISTOLISEMPTY
     *
     * @param actor adjacent to water
     * @return true if the actor's inventory has the water pistol with GameSkills.PISTOLISEMPTY. false otherwise
     */
    private boolean containsPistol(Actor actor) {
        return actor.hasSkill(GameSkills.PISTOLISEMPTY);
    }

    /**
     * Checks if the actor's inventory has an empty bucket item that has skill BonusGameSkills.BUCKETISEMPTY
     *
     * @param actor adjacent to water
     * @return true if the actor's inventory has the bucket with GameSkills.PISTOLISEMPTY. false otherwise
     */
    private boolean containsBucket(Actor actor) {
        return actor.hasSkill(BonusGameSkills.BUCKETISEMPTY);
    }
}

