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

        for (Item item : actor.getInventory()){
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                addRocketBody(actor);
                actor.removeItemFromInventory(item);
            }
        }
        return "Rocket body is added to the Player's inventory\nRocket plan is removed from Player's inventory";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " substitutes rocket plan for rocket body";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private void addRocketBody(Actor actor) {
        Item rocketBody = new Item("rocket body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        actor.addItemToInventory(rocketBody);
    }

    }
