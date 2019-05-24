package game;

import edu.monash.fit2099.engine.*;

/**
 * This class provides static methods to get the distance between two actors and to check if they are adjacent
 * to each other.
 * @author Team Kimchi
 */
public class Distance {

    /**
     * Calculates the Manhattan distance between the actor and the target.
     *
     * @param a Location of actor a
     * @param b Location of actor b
     * @return The distance between a and b if the values of a and b are not null.
     * If either a or b or both are null, return 0
     */
    public static int distance(Location a, Location b) {
        int distance;
        try {
            distance = Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
            return distance;
        }
        catch (NullPointerException npe) {
            distance = 0;
        }
        return distance;
    }

    /**
     * Checks if the subject is adjacent to the actor
     * @param actor actor on the map
     * @param subject subject to check if adjacent to the actor
     * @return true if subject is adjacent to actor. false otherwise
     */
    public static boolean isAdjacent(Location actor, Actor subject) {
        for (Exit exit : actor.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getActor() == subject) {
                return true;
            }
        }
        return false;
    }

}
