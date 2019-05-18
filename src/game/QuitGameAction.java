package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class QuitGameAction extends Action {

    QuitGameAction () {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return actor + " quits the game. Goodbye";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " quits the game";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
