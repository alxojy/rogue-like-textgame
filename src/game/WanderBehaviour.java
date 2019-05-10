package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

/**
 * This class represents the wander behaviour and creates an Action for the actor to wander around the map.
 * @author Team Kimchi
 */
public class WanderBehaviour implements ActionFactory {

    private Random rand = new Random();
    
    /**
     * Returns a newly instantiated MoveActorAction.
     *
     * Randomly chooses one destination from a list of possible destinations. List exits stores all the possible routes
     * from a location.
     *
     * Generates a random number (from 0 - exits.size()) and use it to retrieve the direction stored at exits
     * index. If the next destination is a valid destination, it returns a new MoveActorAction that will move Actor
     * to the new location. Else, it will generate another number.
     *
     * @param actor the actor to move
     * @param map the map that actor is acting on
     * @return A newly instantiated MoveActorAction that will move the Actor to the randomly chosen location
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



