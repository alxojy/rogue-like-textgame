package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Grunt extends Enemy {

	// Grunts have 50 hitpoints and are always represented with a g
	public Grunt(String name, Actor player) {
		super(name, 'g', 6, 2);
		addBehaviour(new FollowBehaviour(player));
	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		return super.playTurn(actions,  map,  display);
	}

	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(1, "slaps");
	}

}
