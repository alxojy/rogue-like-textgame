package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

/**
 * The WanderBehaviour class creates a new action which allows
 * the actor to wander around the map.
 * @author Team Kimchi
 *
 */
public class WanderBehaviour implements ActionFactory {

    private Random rand = new Random();
    
    /**
     * Randomly chooses one destination from a list of possible destinations.
     * exits stores all the possible routes from a location. 

     * IE: if Actor is on the top right corner of the map, then the
     * possible movements are to move down / move to the left. In this case, the length of exits is 2.
     * However, under normal circumstances where Actor is not surrounded by anything, the possible movements are
     * to move up/down/right/left. In this case, the length of exit is 4.
     *
     * getAction works by:
     * Generating a random number (from 0 - length of exits) and use it to retrieve the direction stored at that
     * index. If the next destination is a valid destination , it returns new MoveActorAction that will move Actor 
     * to the new location. Else, it will generate another number. This process repeats until a valid number is chosen.
     *
     *
     * @param actor the actor to move
     * @param map the map that actor is acting on
     * @return new MoveActorAction that will move the Actor to the randomly chosen location
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



