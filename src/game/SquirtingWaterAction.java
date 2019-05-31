package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.Random;

/**
 * This class represents an Action that squirts water at yugoMaxx
 * @author Team Kimchi
 */
public class SquirtingWaterAction extends Action {

    private YugoMaxx yugoMaxx;
    private Item waterPistol;
    private Random random = new Random();

    /**
     * Constructor
     *
     * @param subject yugoMaxx
     * @param waterPistol the water pistol item that will perform this action
     */
    SquirtingWaterAction(YugoMaxx subject, Item waterPistol) {
        yugoMaxx = subject;
        this.waterPistol = waterPistol;
    }

    /**
     * Performs the action to squirt water at yugoMaxx
     *
     * Overrides its superclass's execute method and performs either of the following tasks:
     * 1. Replaces GameSkills.PISTOLISFULL with GameSkills.PISTOLISEMPTY to indicate that the waterPistol is now empty
     * 2. Squirs Water at yugoMaxx and there is a 70% chance that exoskeleton will be destroyed
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing the action performed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        waterPistol.removeSkill(GameSkills.PISTOLISFULL);
        waterPistol.addSkill(GameSkills.PISTOLISEMPTY);

        if (random.nextDouble() <= 0.70) {
            yugoMaxx.removeExoskeleton();
            return actor + " successfully squirted water at " + yugoMaxx + "\n" +
                    yugoMaxx + "'s exoskeleton has been removed.";
        }
        else {
            return actor + " missed " + yugoMaxx;
        }
    }

    /**
     * Returns a description of the SquirtingWaterAction to display on the menu.
     *
     * @param actor The actor performing the action.
     * @return A String describing the SquirtingWaterAction
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " squirts water at " + yugoMaxx;
    }

    /**
     * Returns the empty String, as no hotKey is permanently assigned to SquirtingWaterAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }
}
