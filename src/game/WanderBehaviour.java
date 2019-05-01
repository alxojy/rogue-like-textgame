package game;

import edu.monash.fit2099.engine.*;

import java.util.List;
import java.util.Random;

public class WanderBehaviour implements ActionFactory {
    /*
    This class implements the wander behaviour of Q whereby it is wandering around the map
     */
    private Random rand = new Random();


    public Action getActions(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location destination = here;
        String direction = "";
        int ranNum = rand.nextInt(4);
        System.out.println(ranNum);
        if (ranNum == 0) {
            direction = "East";
        } else if (ranNum == 1) {
            destination = new Location(map, here.x() - 1, here.y());
            direction = "West";
        } else if (ranNum == 2) {
            destination = new Location(map, here.x(), here.y() + 1);
            direction = "North";
        } else if (ranNum == 3) {
            destination = new Location(map, here.x(), here.y() - 1);
            direction = "South";
        }

        return new MoveActorAction(destination, direction);
    }

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




