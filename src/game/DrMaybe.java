package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class DrMaybe extends Actor {

    private Random rand = new Random();

    DrMaybe() {
        super("Dr Maybe", 'M', 10, 25);
        addItemToInventory(createRocketEngine());
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        Action action = actions.get(rand.nextInt(actions.size()));
        if (isConscious() && !(action instanceof DropItemAction)) {
            return action;
        }
        else {
            return new SkipTurnAction();
        }
    }

    private Item createRocketEngine() {
        Item rocketEngine = Item.newInventoryItem("rocket engine", 'e');
        rocketEngine.addSkill(GameSkills.BUILDROCKETBASE);
        return rocketEngine;
    }
}
