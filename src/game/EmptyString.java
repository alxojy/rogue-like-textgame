package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.SkipTurnAction;

/**
 * This class returns an empty String
 * @author Team Kimchi
 */
public class EmptyString extends SkipTurnAction {

    @Override
    public String menuDescription(Actor actor) {
        return "";
    }
}
