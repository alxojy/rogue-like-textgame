package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

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



