package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * This class represents the Action that fills the empty water pistol
 * @author Team Kimchi
 */
public class FillEmptyPistolAction extends Action {

    /**
     * Performs the Action of filling the actor's empty water pistol.
     *
     * Replaces the skill GameSkills.PISTOLISEMPTY to GameSkills.PISTOLISFULL to indicate that the water pistol has
     * been filled with water.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A String describing that the water pistol has been filled.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for (Item item : actor.getInventory()) {
            if (item.hasSkill(GameSkills.PISTOLISEMPTY)) {
                item.removeSkill(GameSkills.PISTOLISEMPTY);
                item.addSkill(GameSkills.PISTOLISFULL);

                return "The water pistol is filled";
            }
        }
        return "";
    }

    /**
     * Returns a String description for displaying in the menu, which is fills empty water pistol
     *
     * @param actor The actor performing the action.
     * @return A String describing the fill empty water pistol Action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " fills their empty water pistol";
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
