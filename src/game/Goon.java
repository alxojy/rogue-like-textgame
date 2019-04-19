package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Goon extends Enemy {

    private Random rand;

    public Goon(String name, Actor player) {
        super(name, 'G', 5, 50);
        super.addBehaviour(new FollowBehaviour(player));
        super.addBehaviour(new ShoutInsultBehaviour(player));
    }
 /*
    @Override
    //must implement 10% chance tmr
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(2, "shouts insults at");
    }
    */
}
