package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;


public class GivePlansAction extends Action {
    private Actor subject;
    GivePlansAction(Actor actor) {
        subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //if actor.getInventory()
        addRocketBody(actor);
        return "rocket is added ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " creates a rocket";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private void addRocketBody(Actor actor) {
        Item rocketBody = new Item("Rocket Body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        actor.getInventory().add(rocketBody);
    }
    }
