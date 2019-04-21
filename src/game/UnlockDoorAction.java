package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

import java.util.Random;

public class UnlockDoorAction extends Action {

    private String direction;
    private Location doorLocation;

    public UnlockDoorAction(String direction, Location doorLocation) {
        this.direction = direction;
        this.doorLocation = doorLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.add(new Floor(), doorLocation);
        return "The door is unlocked";

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " unlocks a door";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
