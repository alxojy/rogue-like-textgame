package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents an enemy, Goon who is also an actor
 * @author Team Kimchi
 */
public class Goon extends Enemy {
    public final static int GOON_DAMAGE = Grunt.GRUNT_DAMAGE*2;

    /**
     * Constructor.
     *
     * Goon has 50 hitPoints and is always represented with a 'G'
     * Constructor calls addBehaviour to add ShoutInsultBehaviour and FollowBehaviour.
     * The ShoutInsultBehaviour shouts insults at the player and the FollowBehaviour follows the player.
     *
     * @param name Name of the Goon object
     * @param player Player in the game
     */
    Goon(String name, Actor player) {
        super(name, 'G', 2, 50, player);
        addBehaviour(new ShoutInsultBehaviour(player));
        addBehaviour(new FollowBehaviour(player));
    }

    /**
     * Creates an intrinsic weapon which punches.
     *
     * Uses Grunt class's static variable to get twice of Grunt's damage.
     *
     * @return a newly instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(GOON_DAMAGE, "punches");
    }
}
