package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class ShoutInsultBehaviour implements ActionFactory {

    private Actor target;
    private Random rand = new Random();

    public ShoutInsultBehaviour(Actor subject) {
        this.target = subject;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextDouble() <= 0.1) {
            return new AttackAction(actor, target);
        }
        return new SkipTurnAction();
    }
}
