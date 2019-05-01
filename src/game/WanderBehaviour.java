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
        List<Exit> posMoves = here.getExits();
        boolean flag = false;

        while (!flag) {

            int ranNum = rand.nextInt(4);
            destination = posMoves.get(ranNum).getDestination();
            direction = posMoves.get(ranNum).getName();
            System.out.println(destination.x());
            System.out.println(destination.y());
            if( destination.canActorEnter(actor)){
                try{
                    map.moveActor(actor,destination);
                    flag = true;
                }
                catch (IndexOutOfBoundsException e){
                    flag = false;
                }

            }
        }
            return new MoveActorAction(destination, direction);
        }
    }




