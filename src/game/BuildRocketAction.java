package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;

import java.util.ArrayList;

public class BuildRocketAction extends Action {

    private Actor subject;

    BuildRocketAction(Actor actor) {
        subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addItemToInventory(createRocket());
        return "rocket has been created";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " creates a rocket";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private Item createRocket() {
        Item rocket = Item.newInventoryItem("rocket", 'R');
        return rocket;
    }
}
