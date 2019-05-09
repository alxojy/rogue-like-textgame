package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an enemy, Grunt who is also an actor
 * @author Team Kimchi
 */
public class Grunt extends Enemy {

	final static int GRUNT_DAMAGE = 2;
	/**
	 * Grunts have 50 hitPoints and are always represented with a 'g'
	 * Constructor calls addBehaviour to add FollowBehaviour to follow the player
	 *
	 * @param name name of the Grunt object
	 * @param player player in the game
	 */
	Grunt(String name, Actor player) {
		super(name, 'g', 3, 50, player);
		addBehaviour(new FollowBehaviour(player));
	}

	/**
	 * Creates an intrinsic weapon which slaps
	 *
	 * @return a newly instantiated IntrinsicWeapon
	 */
	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(GRUNT_DAMAGE, "slaps");
	}

}
