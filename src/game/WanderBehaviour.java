package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

/**
 * The WanderBehaviour class creates a new action which allows
 * the actor to wander around the map.
 *
 */
public class WanderBehaviour implements ActionFactory {

    private Random rand = new Random();
    /**
     * Randomly chooses one destination from a list of possible destinations.
     * Returns new MoveActorAction that will move the Actor to the randomly chosen Location.
     *
     * @param actor the actor to move
     * @param map the map that actor is acting on
     * @return new MoveActorAction that will move the Actor
     */
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location destination = null;
        String direction = "";
        List<Exit> exits = here.getExits();
        boolean flag = false;

        while (!flag) {

            int ranNum = rand.nextInt(exits.size());
            destination = exits.get(ranNum).getDestination();
            direction = exits.get(ranNum).getName();

            if (destination.canActorEnter(actor)) {
                flag = true;
            }
        }
        return new MoveActorAction(destination, direction);
    }
}



