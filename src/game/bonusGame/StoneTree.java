package game.bonusGame;

import edu.monash.fit2099.engine.*;
import game.GamePlayer;

/**
 * This class represents Stone Tree which is an Actor that drops stones and allows the player to redeem items
 * @author Team Kimchi
 */
public class StoneTree extends Actor {

    private GamePlayer player;

    /**
     * Constructor.
     *
     * @param player The player in the game.
     */
    public StoneTree(GamePlayer player) {
        super("Stone Tree", 'T', 5, 50);
        this.player = player;
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        return new TreeTalkAction(player, this);
    }

    /**
     * Returns a List of Actions that can be performed by the actor adjacent to the stone tree.
     *
     * Adds a newly instantiated WaterTreeAction into a List of Actions that otherActor can perform if the otherActor has
     * a filled bucket. If the tree has not been fertilised, adds a newly instantiated RedeemFertiliserAction into the
     * List of Actions. Newly instantiated RedeemTicketAction and RedeemSwordAction are always added into the List of Actions.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a List of Actions that can be performed by the actor adjacent to the stone tree
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        for (Item currentItem: otherActor.getInventory()) {
            if (currentItem.hasSkill(BonusGameSkills.BUCKETISFULL)) {
                actions.add(new WaterTreeAction(player, this, currentItem));
            }
        }
        actions.add(new RedeemTicketAction(player));
        if (!hasFertiliser()) {
            actions.add(new RedeemFertiliserAction(this, player));
        }
        actions.add(new RedeemSwordAction(player));
        return actions;
    }

    /**
     * This method checks if Stone Tree is fertilised
     * @return true if fertilised, false if otherwise
     */
    public boolean hasFertiliser() {
        return this.hasSkill(BonusGameSkills.FERTILISER);
    }

    /**
     * This method adds BonusGameSkills.FERTILISER to Stone Tree
     */
    public void addFertiliser() {
        addSkill(BonusGameSkills.FERTILISER);
    }
}