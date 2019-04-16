package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public abstract class Enemy extends Actor {

    protected List<Item> inventory = new ArrayList<>();

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

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null) {
                return action;
            }
        }
        return super.playTurn(actions,  map,  display);
    }

    @Override
    public List<Item> getInventory() {
        if (!super.isConscious()) {
            inventory.add(createKey());
            }
        return inventory;
    }

    private Item createKey() {
        Item key = new Item("key", 'K');
        key.addSkill(GameSkills.UNLOCKDOOR);
        return key;
    }

}
