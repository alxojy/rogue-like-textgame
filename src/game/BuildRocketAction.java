package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;


public class BuildRocketAction extends Action {

    private Actor subject;
    private Location location ;
    private Item rocketBody , rocketEngine ;



    BuildRocketAction(Actor actor,Location location, Item rocketBody, Item rocketEngine) {
        this.location = location;
        this.rocketBody = rocketBody;
        this.rocketEngine = rocketEngine;
        subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addItemToInventory(createRocket());
        location.removeItem(rocketBody);
        location.removeItem(rocketEngine);
        if (actor instanceof GamePlayer){
            ((GamePlayer) actor).removePlayerFromMap((GamePlayer) actor);
        }
        return "You have completed the game!\nRocket has been created";
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
        return Item.newInventoryItem("rocket", 'R');
    }
}
