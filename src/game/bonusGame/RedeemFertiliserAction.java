package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.GamePlayer;

public class RedeemFertiliserAction extends Action {

    private StoneTree stoneTree;
    private GamePlayer gamePlayer;

    RedeemFertiliserAction(StoneTree stoneTree, GamePlayer gamePlayer) {
        this.stoneTree = stoneTree;
        this.gamePlayer = gamePlayer;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        stoneTree.addFertiliser();
        gamePlayer.getStoneCounter().decrement(3);
        return "The stone tree has been fertilised";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " adds fertiliser to the stone tree";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
