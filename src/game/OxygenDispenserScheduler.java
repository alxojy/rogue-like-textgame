package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenserScheduler extends Actor {

    Actor player;

    // variables for the current turn number
    private final int ROUND_ZERO = 0;
    private final int ROUND_ONE = 1;
    private final int ROUND_TWO = 2;

    private MaxCounter counter = new MaxCounter(3);

    OxygenDispenserScheduler(Actor player) {
        super("oxygen dispenser", 'O', 2, 50);
        this.player = player;
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        if (counter.getValue() == ROUND_ONE) {
            counter.increment();
            return new SkipTurnAction();
        }
        else if (counter.getValue() == ROUND_TWO) {
            return new DispenseOxygenTankAction(this);
        }
        return new SkipTurnAction();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        if (counter.getValue() == ROUND_ZERO) {
            actions.add(new PressButtonAction(otherActor, counter));
        }
        return actions;
    }

}
