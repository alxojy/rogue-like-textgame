package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class BuildRocketAction extends Action {

    private Actor subject;

    BuildRocketAction(Actor actor) {
        subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.getInventory().add(createRocket());
        return "rocket has been created";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " created a rocket";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private Item createRocket() {
        Item rocket = new Item("rocket", 'R');
        return rocket;
    }
}
