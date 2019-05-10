package game;

import edu.monash.fit2099.engine.*;

/**
 * The FollowBehaviour class creates a new Action which allows the actor
 * to follow another actor (which is the target) around the map.
 * @author Team Kimchi
 */
public class FollowBehaviour implements ActionFactory {

	private Actor target;

	/**
	 * Constructor.
	 *
	 * @param subject The actor to follow.
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	/**
	 * Returns a newly instantiated MoveActorAction or null based on the destination distance between the actor and the target.
     *
     * 1. Gets the current location of the Actor and the target actor
	 * 2. -If the destination distance of the actor is less than the current distance between the actor and the target actor,
	 *     it will return a new MoveActorAction that will move the Actor to the new location which is closer to
	 *     the target.
	 *    -If the destination distance of the actor is more than or equal to the current distance between the actor and the
	 *     target actor, it will return null
	 *
	 * @param actor The actor to move
	 * @param map The map that actor is acting on
	 * @return Newly instantiated MoveActorAction if the destination distance is less than the current distance.
	 * If the destination distance is more than or equal to the current distance, return null.
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) throws NullPointerException {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = Distance.distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = Distance.distance(destination, there);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}

		return null;
	}

}