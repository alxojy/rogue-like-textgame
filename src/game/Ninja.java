package game;

import edu.monash.fit2099.engine.*;

public class Ninja extends Enemy {

    public Ninja(String name, Actor player) {
        super(name, 'n', 5, 50);
        super.addBehaviour(new StunBehaviour(this, player));
    }
}
