package game;

import edu.monash.fit2099.demo.Floor;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

import java.util.Random;

public class UnlockDoorAction extends Action {

    public UnlockDoorAction() {
    }

    @Override
    public String execute(Actor actor, GameMap map) {
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
