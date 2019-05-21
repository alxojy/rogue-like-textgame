package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an enemy, Grunt who is also an actor
 * @author Team Kimchi
 */
public class Grunt extends Enemy {

	/**
	 * final static constants for Grunt's damage and hitPoints.
	 */
	final static int GRUNT_DAMAGE = 2;
	final static int GRUNT_HITPOINTS = 50;

	/**
	 * Constructor.
	 *
	 * Grunts have 50 hitPoints and are always represented with a 'g'.
	 * Constructor calls addBehaviour to add FollowBehaviour to follow the player.
	 *
	 * @param name Name of the Grunt object
	 * @param player Player in the game
	 */
	Grunt(String name, Actor player) {
		super(name, 'g', 3, GRUNT_HITPOINTS, player);
		addBehaviour(new FollowBehaviour(player));
	}

	/**
	 * Creates an intrinsic weapon which slaps.
	 *
	 * @return a newly instantiated IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(GRUNT_DAMAGE, "slaps");
	}

}
