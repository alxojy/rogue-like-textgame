package game.bonusGame;

import edu.monash.fit2099.engine.*;
import game.GamePlayer;

public class StoneTree extends Actor {

    private GamePlayer player;

    public StoneTree(GamePlayer player) {
        super("Stone Tree", 'T', 6, 50);
        this.player = player;
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        return new SkipTurnAction();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        for (Item currentItem: otherActor.getInventory()) {
            if (currentItem.hasSkill(BonusGameSkills.WATERTREE)) {
                actions.add(new WaterTreeAction(player));
            }
        }
        return actions;
    }
}

