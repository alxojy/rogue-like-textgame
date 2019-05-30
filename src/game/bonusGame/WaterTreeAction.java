package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.GamePlayer;

import java.util.Random;

public class WaterTreeAction extends Action {

    private GamePlayer player;
    private Item bucket;
    private StoneTree stoneTree;

    WaterTreeAction(GamePlayer player, StoneTree stoneTree, Item bucket) {
        this.player = player;
        this.stoneTree = stoneTree;
        this.bucket = bucket;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        bucket.removeSkill(BonusGameSkills.BUCKETISFULL);
        bucket.addSkill(BonusGameSkills.BUCKETISEMPTY);
        if (new Random().nextBoolean()) {
            return "Better luck next time. No stones has been added to " + actor + "'s inventory";
        }
        else {
            if (stoneTree.hasFertiliser()) {
                player.getStoneCounter().increment();
                return "One stone has been added to " + actor + "'s inventory";
            }
            else {
                player.getStoneCounter().increment(2);
                return "Two stones has been added to " + actor + "'s inventory";
            }
        }
    }

    @Override
    public String menuDescription(Actor actor) { return actor + " waters the tree";}

    @Override
    public String hotKey() {
        return "";
    }

}
