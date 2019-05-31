package game.bonusGame;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.Counter;
import game.GamePlayer;

/**
 * This class represents the Action of redeeming the fertiliser for the stone tree
 * @author Team Kimchi
 */
public class RedeemFertiliserAction extends RedeemAction {

    private StoneTree stoneTree;
    private GamePlayer gamePlayer;
    private final static BonusGameSkills fertiliserSkills = BonusGameSkills.FERTILISER;

    /**
     * Constructor.
     *
     * Calls its superclass' addItemValue method to initialise the value of fertiliser = 3 stones
     *
     * @param stoneTree the stone tree subject
     * @param gamePlayer the player in the game
     */
    RedeemFertiliserAction(StoneTree stoneTree, GamePlayer gamePlayer) {
        this.stoneTree = stoneTree;
        this.gamePlayer = gamePlayer;
        super.addItemValue(fertiliserSkills, 3);
    }

    /**
     * Performs the Action of adding fertiliser to the stone tree so that it will produce 2 stones.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on
     * @return A String describing that the stone tree has been fertilised if the player has sufficient number of stones
     */
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

    /**
     * Returns a String description for displaying in the menu, which is adds fertiliser to the stone tree
     *
     * @param actor The actor performing the action.
     * @return A String describing the fertilise stone tree action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " adds fertiliser to the stone tree to produce 2 stones (3 stones)";
    }

    /**
     * Returns the empty String, as no hotKey is permanently assigned to RedeemFertiliserAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }
}
