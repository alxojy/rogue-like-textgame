package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;


public class GivePlansAction extends Action {
    private Actor subject;
    private Actor Q;
    GivePlansAction(Actor actor,Actor Q) {
        subject = actor;
        this.Q = Q;

    }

    @Override
    public String execute(Actor player, GameMap map) {

        for (Item item : player.getInventory()){
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                addRocketBody(player);
                player.removeItemFromInventory(item);
                map.removeActor(Q);
                System.out.println("Q disappeared with a cherry wave.");
            }
        }
        return "Rocket Body is added to the Player's Inventory\nRocket Plan is removed from Player's inventory";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " substitutes Rocket Plan for Rocket Body";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private void addRocketBody(Actor actor) {
        Item rocketBody = new Item("Rocket Body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        actor.addItemToInventory(rocketBody);
    }
    }
