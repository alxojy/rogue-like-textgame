package game;

import edu.monash.fit2099.engine.*;

/**
 * The FollowBehaviour class creates a new action which allows the actor
 * to follow another actor (which is the target) around the map
 */
public class FollowBehaviour implements ActionFactory {

	private Actor target;

	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	/**
	 * Returns a newly instantiated MoveActorAction or null based on the destination distance between the actor and the target
     *
     * 1. Gets the current location of the Actor and the target actor
	 * 2. -If the destination distance of the actor is less than the current distance between the actor and the target actor,
	 *     it will return a new MoveActorAction that will move the Actor to the new location which is closer to
	 *     the target.
	 *    -If the destination distance of the actor is more than or equal to the current distance between the actor and the
	 *     target actor, it will return null
	 *
	 * @param actor the actor to move
	 * @param map the map that actor is acting on
	 * @return newly instantiated MoveActorAction if the destination distance is less than the current distance.
	 * If the destination distance is more than or equal to the current distance, return null
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, there);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}

		return null;
	}

    /**
     * Calculates the Manhattan distance between the actor and the target
     *
     * @param a location of actor a
     * @param b location of actor b
     * @return the distance between a and b if the values of a and b are not null
     * if either a or b or both are null, return 0
     */
	private int distance(Location a, Location b) {
		int retVal;
		if (a != null && b != null) {
			retVal = Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
		}
		else {
			retVal = 0;
		}
		return retVal;
	}
}