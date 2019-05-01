package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

public class WanderBehaviour implements ActionFactory {
    /*
    This class implements the wander behaviour of Q whereby it is wandering around the map
     */
    private Random rand = new Random();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        List<Exit> possibleMoves = here.getExits();
        String direction;
        int randomNumber = rand.nextInt(possibleMoves.size());

        Location destination = possibleMoves.get(randomNumber).getDestination();
        direction = possibleMoves.get(randomNumber).getName();

        if (destination.canActorEnter(actor)) {
            return new MoveActorAction(destination, direction);
        }

        return null;
    }

    }




