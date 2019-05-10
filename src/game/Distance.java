package game;

import edu.monash.fit2099.engine.Location;

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
     * Checks if the actors are adjacent to each other by calculating their distance.
     *
     * @param a Location of actor a
     * @param b Location of actor b
     * @return A boolean indicating if a and b are adjacent
     */
    public static boolean isAdjacent(Location a, Location b) {
        return Distance.distance(a, b) == 1;
    }
}
