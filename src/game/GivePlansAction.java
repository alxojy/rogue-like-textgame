package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * Allows Player to give plans to Q
 */

public class GivePlansAction extends Action {
    private Actor player;
    private Actor Q;

    /**
     * Constructor
     * @param actor the GamePlayer
     * @param Q Q actor
     */
    GivePlansAction(Actor actor,Actor Q) {
        player = actor;
        this.Q = Q;

    }

    /**
     * overrides Action.execute()
     * Executes givePlansAction by checking if player have rocketPlan item in
     * the inventory. If yes , Player substitutes rocketPlan for rocketBody,
     * Q then disappears from the map
     *
     * @param player GamePlayer
     * @param map The map the GamePlayer is on.
     * @return  a string describing what has been executed
     */
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
    /**
     * Returns a string describing the action suitable for displaying in the menu.
     *
     * @param actor The actor performing the action.
     * @return  a string describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return player + " gives plan to Q";
    }
    /**
     * Returns the empty string, as no hotkey is permanently assigned to GivePlanAction.
     * @return the empty string
     */
    @Override
    public String hotKey() {
        return "";
    }

    /**
     * Creates the rocketBody which has the GameSkills.BUILDROCKETTOP.
     * if player successfully swaps item with Q , the rocketBody item will be added into the GamePlayer's inventory
     * @return the rocketBody item
     */
    private Item createRocketBody() {
        Item rocketBody = Item.newInventoryItem("rocket body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        return rocketBody;
    }

    }
