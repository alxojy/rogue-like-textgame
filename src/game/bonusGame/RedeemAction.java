package game.bonusGame;

import edu.monash.fit2099.engine.Action;

import java.util.HashMap;
import java.util.Map;

public abstract class RedeemAction extends Action {

    private Map<BonusGameSkills, Integer> itemToStoneMap = new HashMap<BonusGameSkills, Integer>(); {
    }
    public boolean checkStones(){

    }
}
