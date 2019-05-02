package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Goon extends Enemy {

    public Goon(String name, Actor player) {
        super(name, 'G', 5, 50);
        addBehaviour(new ShoutInsultBehaviour(player));
        addBehaviour(new FollowBehaviour(player));
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches");
    }

}
