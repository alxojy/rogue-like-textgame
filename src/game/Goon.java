package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Goon extends Enemy {

    public Goon(String name, Actor player) {
        super(name, 'G', 5, 50, new FollowBehaviour(player));
    }

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;
        }

        return super.playTurn(actions,  map,  display);
    }

    @Override
    //must implement 10% chance tmr
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(2, "shouts insults at");
    }
}
