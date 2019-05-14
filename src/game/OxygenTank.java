package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {

    private MaxCounter oxygenPoint = new MaxCounter(11);

    OxygenTank(Actor actor) {
        Item oxygenTank = new Item("oxygen tank", 'o');
    }

}
