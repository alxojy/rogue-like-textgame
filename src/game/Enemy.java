package game;

import edu.monash.fit2099.engine.Actor;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends Actor {

    Enemy(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    Enemy(String name, char displayChar, int priority, int hitPoints, ActionFactory behaviour) {
        super(name, displayChar, priority, hitPoints);
        addBehaviour(behaviour);
    }

    private List<ActionFactory> actionFactories = new ArrayList<>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

}
