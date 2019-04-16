package game;

import edu.monash.fit2099.engine.*;

public class NinjaBehaviour implements ActionFactory {

    private Actor target;

    public NinjaBehaviour(Actor subject) {
        this.target = subject;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int currentDistance = distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                if (currentDistance <= 5) {
                    new StunAttackAction(actor, target);
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }

        return null;
    }

    // Manhattan distance.
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
