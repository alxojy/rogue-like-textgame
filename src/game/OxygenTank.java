package game;

import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {

    private MaxCounter oxygenPoint = new MaxCounter(11);

    OxygenTank() {
        super("oxygen tank", 'o');
    }

}
