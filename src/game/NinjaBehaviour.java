package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class NinjaBehaviour implements ActionFactory {

    private Actor target;
    private Random rand = new Random();

    NinjaBehaviour(Actor subject) {
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
                if (currentDistance <= 5 && rand.nextBoolean()) {
                    return new StunAttackAction(actor, target);
                }
                else if (currentDistance > 5 || !rand.nextBoolean()) {
                    return new SkipTurnAction();
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
