package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an enemy, Grunt
 */
public class Grunt extends Enemy {

	/**
	 * Grunts have 50 hitPoints and are always represented with a 'g'
	 * Calls addBehaviour in the constructor to add FollowBehaviour to follow the player
	 *
	 * @param name name of the Grunt object
	 * @param player player in the game
	 */
	public Grunt(String name, Actor player) {
		super(name, 'g', 6, 2);
		addBehaviour(new FollowBehaviour(player));
	}

	/**
	 * Creates an intrinsic weapon which slaps
	 *
	 * @return a newly instantiated IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(1, "slaps");
	}

}
