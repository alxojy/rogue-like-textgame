package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.Counter;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides methods for its subclasses to redeem items.
 * Abstract class created to ensure that its subclasses implement its superclass' abstract methods.
 */
public abstract class RedeemAction extends Action {

    /**
     * Stores the value of the stone related to the item to be redeemed
     */
    private Map<BonusGameSkills, Integer> itemToStoneMap = new HashMap<BonusGameSkills, Integer>();

    /**
     * Adds the value of the stone to the item to be redeemed.
     *
     * @param bonusGameSkills the skill that the item has
     * @param stoneValue the value of the stone needed to redeem the item
     */
    protected void addItemValue(BonusGameSkills bonusGameSkills,Integer stoneValue){
        itemToStoneMap.put(bonusGameSkills, stoneValue);
    }

    /**
     * If the actor does not have sufficient number of stones to redeem the item, return the String indicating that
     * the item cannot be redeemed
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The String indicating that the actor does not have enough stones to redeem the item
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return actor + " does not have enough stones to redeem the item";
    }

    /**
     * Checks if the player has enough stones to redeem the item
     *
     * @param bonusGameSkills the skill that the item has
     * @param counter player's stone counter
     * @return returns true if the player has sufficient stones. false otherwise
     */
    public boolean checkSufficientStones(BonusGameSkills bonusGameSkills, Counter counter) {
        return itemToStoneMap.get(bonusGameSkills) <= counter.getValue();
    }

    /**
     * Reduces the player's stone counter after redeeming the item
     *
     * @param bonusGameSkills the skill that the item has
     * @param counter player's stone counter
     */
    public void redeem(BonusGameSkills bonusGameSkills, Counter counter) {
        counter.decrement(itemToStoneMap.get(bonusGameSkills));
    }
}
