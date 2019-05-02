package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Actor {

    Enemy(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
        addItemToInventory(createKey());
    }

    private List<ActionFactory> actionFactories = new ArrayList<>();

    public void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        Action actionToReturn = new SkipTurnAction();
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null) {
                return action;
            }
        }
        for (Action action: actions) {
            if (!(action instanceof DropItemAction)) {
                return action;
            }
        }
        return actionToReturn;
    }

    /**
     * This method instantiates a new Item object that represents a key in the game
     * @return an Item key, that has skill GameSkills.UNLOCKDOOR
     */
    private Item createKey() {
        Item key = Item.newInventoryItem("key", 'K');
        key.addSkill(GameSkills.UNLOCKDOOR);
        return key;
    }
}
