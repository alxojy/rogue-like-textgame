package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;


/**
 * This class represents the Action that fills the empty bucket
 * @author Team Kimchi
 */
public class FillBucketAction extends Action {

    /**
     * Performs the Action of filling the actor's empty bucket.
     *
     * Replaces the skill BonusGameSkills.BUCKETISEMPTY to BonusGameSkills.BUCKETISFULL to indicate that the bucket has
     * been filled with water.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A String describing that the bucket has been filled.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item item : actor.getInventory()) {
            if (item.hasSkill(BonusGameSkills.BUCKETISEMPTY)) {
                item.removeSkill(BonusGameSkills.BUCKETISEMPTY);
                item.addSkill(BonusGameSkills.BUCKETISFULL);

                return "The water bucket is filled";
            }
        }
        return "";
    }

    /**
     * Returns a String description for displaying in the menu, which is fills empty bucket
     *
     * @param actor The actor performing the action.
     * @return A String describing the fill empty water pistol Action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " fills their water bucket";
    }

    /**
     * Returns the empty String, as no hotKey is permanently assigned to FillEmptyPistolAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }

    }
