package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.SkipTurnAction;

public class EmptyString extends SkipTurnAction {

    @Override
    public String menuDescription(Actor actor) {
        return "";
    }
}
