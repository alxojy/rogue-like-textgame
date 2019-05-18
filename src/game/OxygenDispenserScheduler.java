package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenserScheduler extends Actor {

    Actor player;

    private MaxCounter counter = new MaxCounter(3);

    OxygenDispenserScheduler(Actor player) {
        super("oxygen dispenser", 'O', 2, 50);
        this.player = player;
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        if (counter.getValue() == 1) {
            counter.increment();
            return new SkipTurnAction();
        }
        else if (counter.getValue() == 2) {
            return new DispenseOxygenTankAction(this);
        }
        return new SkipTurnAction();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        if (counter.getValue() == 0) {
            actions.add(new PressButtonAction(otherActor, counter));
        }
        return actions;
    }

}
