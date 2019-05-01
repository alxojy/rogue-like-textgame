package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Q extends Actor {

    public Q() {
        super("Q", 'Q', 5, 0);
        addBehaviour(new WanderBehaviour());
    }

    private List<ActionFactory> actionFactories = new ArrayList<>();

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
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        for (Item item : otherActor.getInventory()) {
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                actions.add(new GivePlansAction(otherActor));
            }
        }
        actions.add(new TalkAction(this, otherActor));
        return actions;
    }
}

