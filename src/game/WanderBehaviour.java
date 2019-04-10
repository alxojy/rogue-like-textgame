package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class WanderBehaviour implements ActionFactory {
    /*
    This class implements the wander behaviour of Q whereby it is wandering around the map
     */

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                return new MoveActorAction(destination, exit.getName());
            }
        }
        return null;
    }

}
