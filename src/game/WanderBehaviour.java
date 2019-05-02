package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

/**
 * The Wander Behaviour class creates a new action which allows
 * the actor to wander around the map.
 *
 * @author yezea
 * @since 2019/04/30
 *
 */
public class WanderBehaviour implements ActionFactory {
    /*
    This class implements the wander behaviour of Q whereby it is wandering around the map
     */
    private Random rand = new Random();

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



