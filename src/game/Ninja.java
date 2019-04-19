package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Enemy {

    private List<ActionFactory> actionFactories = new ArrayList<>();
    private boolean stunAttackExecuted = false;

    public Ninja(String name, Actor player) {
        super(name, 'n', 5, 50);
        addBehaviour(new StunBehaviour(this, player));
    }

    @Override
    public void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {

        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if (action instanceof StunBehaviour) {
                stunAttackExecuted = true;
            }
            return action;
        }
        return new SkipTurnAction();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        actions.add(new StunBehaviour(this, otherActor));
        return actions;
    }

    public void setStunAttackExecuted(boolean stunAttackExecuted) {this.stunAttackExecuted = stunAttackExecuted;}

    public boolean getStunAttackExecuted() {return stunAttackExecuted;}
}
