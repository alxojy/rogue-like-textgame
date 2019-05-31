package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.GamePlayer;

import java.util.Random;


/**
 * This class represents the Action that waters the stoneTree
 * @author Team Kimchi
 */
public class WaterTreeAction extends Action {

    private GamePlayer player;
    private Item bucket;
    private StoneTree stoneTree;


    /**
     * Constructor.
     *
     * @param player The GamePlayer performing the action.
     * @param  stoneTree  the stone tree that will be watered
     * @param bucket the buket used to water the tree
     */
    WaterTreeAction(GamePlayer player, StoneTree stoneTree, Item bucket) {
        this.player = player;
        this.stoneTree = stoneTree;
        this.bucket = bucket;
    }

    /**
     * Performs the Action of watering the stoneTree
     *
     * Replaces the skill BonusGameSkills.BUCKETISFULL to BonusGameSkills.BUCKETISEMPTY to indicate
     * that the bucket is emptied.
     *
     * There is a 50% chance of dropping stones,
     * -If the stone tree is not fertilised, player's stone counter increments by 1 , returns a message that one stone is added
     * -ELse , player's stone counter increments by 2 , returns a message that two stones are added
     *
     * If no stones is dropped, returns a message that no stones has been added.
     *
     * @param actor The actor performing the action.
     * @param map the map that actor is currently on.
     * @return A String describing that the bucket has been filled.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        bucket.removeSkill(BonusGameSkills.BUCKETISFULL);
        bucket.addSkill(BonusGameSkills.BUCKETISEMPTY);
        if (new Random().nextBoolean()) {
            return "Better luck next time. No stones has been added to " + actor + "'s inventory";
        }
        else {
            if (!stoneTree.hasFertiliser()) {
                player.getStoneCounter().increment();
                return "One stone has been added to " + actor + "'s inventory";
            }
            else {
                player.getStoneCounter().increment(2);
                return "Two stones has been added to " + actor + "'s inventory";
            }
        }
    }

    /**
     * Returns a String description for displaying in the menu, which is waters the tree
     *
     * @param actor The actor performing the action.
     * @return A String describing the water tree Action
     */
    @Override
    public String menuDescription(Actor actor) { return actor + " waters the tree";}

    /**
     * Returns the empty String, as no hotKey is permanently assigned to WaterTreeAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }

}
