package game;

import edu.monash.fit2099.engine.Location;

public class Distance {
    private static int distance;

    /**
     * Calculates the Manhattan distance between the actor and the target
     *
     * @param a location of actor a
     * @param b location of actor b
     * @return the distance between a and b if the values of a and b are not null
     * if either a or b or both are null, return 0
     */
    public static int distance(Location a, Location b) {
        try {
            distance = Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
            return distance;
        }
        catch (NullPointerException npe) {
            distance = 0;
        }
        return distance;
    }

    public static boolean isAdjacent(Location a, Location b) {
        return Distance.distance(a, b) == 1;
    }
}
