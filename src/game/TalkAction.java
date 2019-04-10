package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class TalkAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        return menuDescription(actor);
    }

    //need to somehow update method to have different lines for talk
    @Override
    public String menuDescription(Actor actor) {
        return "Do you have the plans?";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
