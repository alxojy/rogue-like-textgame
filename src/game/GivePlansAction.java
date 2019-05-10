package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * This class represents an Action that gives rocket plans
 * @author Team Kimchi
 */
public class GivePlansAction extends Action {
    private Actor player;
    private Actor Q;

    /**
     * Constructor.
     *
     * @param actor The actor performing the action
     * @param Q The actor giving the rocket plans
     */
    GivePlansAction(Actor actor,Actor Q) {
        player = actor;
        this.Q = Q;
    }

    /**
     * Performs the action of player giving rocket plans and adding rocket body in its inventory.
     *
     * Overrides it superclass's execute method and performs the following tasks:
     * 1. Checks if the player's inventory has the rocket plans by checking if its inventory has Item with
     * GameSkills.GETROCKETBODY. If yes, the player's rocket plans are removed from their inventory and is replaced with
     * an Item rocket body. Q is then removed from the map after giving the player the rocket body.
     *
     * @param player GamePlayer
     * @param map The map the GamePlayer is on.
     * @return  A String describing what has been executed
     */
    @Override
    public String execute(Actor player, GameMap map) {
        for (Item item : player.getInventory()){
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                createRocketBody();
                player.addItemToInventory(createRocketBody());
                player.removeItemFromInventory(item);
                map.removeActor(Q);
            }
        }
        return "Q disappeared with a cherry wave\nRocket body is added to the Player's inventory\n" +
                "Rocket plan is removed from Player's inventory";
    }

    /**
     * Returns a description of the give rocket plans action to display on the menu.
     *
     * @param actor The actor performing the action.
     * @return  a String describing the give rocket plans action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " gives rocket plans to " + Q;
    }

    /**
     * Returns the empty String, as no hotKey is permanently assigned to GivePlansAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }

    /**
     * Creates the rocket body that is an Item which has the GameSkills.BUILDROCKETTOP.
     *
     * @return A newly instantiated Item object that represents a rocket body
     */
    private Item createRocketBody() {
        Item rocketBody = Item.newInventoryItem("rocket body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        return rocketBody;
    }

    }
