package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Counter;

import java.util.HashMap;
import java.util.Map;

public abstract class RedeemAction extends Action {

    private Map<BonusGameSkills, Integer> itemToStoneMap = new HashMap<>();

    public void addItemValue(BonusGameSkills bonusGameSkills,Integer stoneValue){
        itemToStoneMap.put(bonusGameSkills, stoneValue);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return actor + " does not have enough stones to redeem the item";
    }

    public boolean checkSufficientStones(BonusGameSkills bonusGameSkills, Counter counter) {
        return itemToStoneMap.get(bonusGameSkills) <= counter.getValue();
    }

    public void redeem(BonusGameSkills bonusGameSkills, Counter counter) {
        counter.decrement(itemToStoneMap.get(bonusGameSkills));
    }
}
