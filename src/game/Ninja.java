package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Enemy {

    private NinjaBehaviour ninjaBehaviour;
    private List<ActionFactory> actionFactories = new ArrayList<>();
    private Actor player;
    private boolean stunAttackExecuted = false;

    public Ninja(String name, Actor player) {
        super(name, 'n', 5, 50);
        ninjaBehaviour = new NinjaBehaviour(player);
        addBehaviour(ninjaBehaviour);
        this.player = player;
    }

    @Override
    public void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        if (getStunAttackExecuted()) {
            System.out.println("supposed to move away");
            stunAttackExecuted = false;
        }
        else {
            for (ActionFactory factory : actionFactories) {
                Action action = factory.getAction(this, map);
                if (action instanceof StunAttackAction) {
                    stunAttackExecuted = true;
                    return action;
                }
                else {
                    stunAttackExecuted = false;
                }
            }
        }
        return new SkipTurnAction();
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        actions.add(new StunAttackAction(otherActor, this));
        return actions;
    }

    private boolean getStunAttackExecuted() {return stunAttackExecuted;}
}
