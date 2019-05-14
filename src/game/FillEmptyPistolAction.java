package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class FillEmptyPistolAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
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
        return actor + " fills their empty pistol";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
