package game.bonusGame;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Counter;
import game.GamePlayer;

public class RedeemFertiliserAction extends RedeemAction {

    private StoneTree stoneTree;
    private GamePlayer gamePlayer;
    private final static BonusGameSkills fertiliserSkills = BonusGameSkills.FERTILISER;

    RedeemFertiliserAction(StoneTree stoneTree, GamePlayer gamePlayer) {
        this.stoneTree = stoneTree;
        this.gamePlayer = gamePlayer;
        super.addItemValue(fertiliserSkills, 3);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Counter stoneCounter = gamePlayer.getStoneCounter();
        if (checkSufficientStones(fertiliserSkills, stoneCounter)) {
            stoneTree.addFertiliser();
            redeem(fertiliserSkills, stoneCounter);
            return "The stone tree has been fertilised";
        }
        return super.execute(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " adds fertiliser to the stone tree (3 stones)";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
