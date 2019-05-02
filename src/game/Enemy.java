package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Actor {

    private GameMap map;
    private List<ActionFactory> actionFactories = new ArrayList<>();

    Enemy(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
        addItemToInventory(createKey());
    }

    protected void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        this.map = map;
        Action actionToReturn = new SkipTurnAction();
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null) {
                return action;
            }
        }

        boolean flag = true;
        while (flag) {
            Action action = super.playTurn(actions, map, display);
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

    public void removeActor(Actor actor){
        map.removeActor(actor);
    }
}
