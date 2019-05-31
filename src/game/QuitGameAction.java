package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * This class represents the Action to quit the game
 * @author Team Kimchi
 */
public class QuitGameAction extends Action {

    /**
     * This overridden method performs the quit game action by removing the player from the current map.
     *
     * @param actor the actor performing this action (namely ; GamePlayer)
     * @param map The map the GamePlayer is on.
     * @return  A string describing that player quits the game
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " quits the game";
    }

    /**
     * Returns a String describing the Action suitable for displaying in the menu, which is [actor] quits the game
     *
     * @param actor The actor performing the action.
     * @return A String describing the quit game action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " quits the game";
    }


    /**
     * Returns the empty String, as no hotKey is permanently assigned to QuitGameAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }
}
