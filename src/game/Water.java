package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

public class Water extends Ground {

    /**
     * Constructor.
     *
     * Initialises the char to display for water as '~'.
     */
    public Water() {
        super('~');
    }

    /**
     * Locked door is an impassable terrain.
     *
     * @param actor Actor adjacent to the locked door
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) { return false; }
}
