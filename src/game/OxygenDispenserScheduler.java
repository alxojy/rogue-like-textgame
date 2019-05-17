package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenserScheduler extends Actor {

    Actor player;

    public static MaxCounter counter = new MaxCounter(3);

    OxygenDispenserScheduler(Actor player) {
        super("oxygen dispenser", 'O', 2, 50);
        this.player = player;
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        return new SkipTurnAction();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        if (counter.getValue() == 0) {
            actions.add(new PressButtonAction(otherActor));
        }
        else if (!counter.canIncrement()) {
            actions.add(new DispenseOxygenTankAction(otherActor, map.locationOf(otherActor)));
        }
        return actions;
    }


}
