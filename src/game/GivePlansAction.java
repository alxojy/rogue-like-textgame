package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Actions;



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
                createRocketBody();
                player.addItemToInventory(createRocketBody());
                player.removeItemFromInventory(item);
                map.removeActor(Q);
                System.out.println("Q disappeared with a cherry wave.");
            }
        }
        return "Rocket body is added to the Player's inventory\nRocket plan is removed from Player's inventory";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " gives plan to Q";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private Item createRocketBody() {
        Item rocketBody = new Item("rocket body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        return rocketBody;
    }

    }
