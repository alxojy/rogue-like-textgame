package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class represents an actor who is a researcher called Doctor Maybe
 */
public class DrMaybe extends Actor {

    private Random rand = new Random();

    DrMaybe() {
        super("Dr Maybe", 'M', 10, 2);
        addItemToInventory(createRocketEngine());
    }

    /**
     *The playTurn method gets a random Action to perform from actions. The Action cannot be an
     * instance of DropItemAction
     *
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        Action action = actions.get(rand.nextInt(actions.size()));
        boolean flag = true;

        while (flag) {
            if (!(action instanceof DropItemAction)) {
                flag = false;
            }
            else {
                action = actions.get(rand.nextInt(actions.size()));
            }
        }
        return action;
    }

    /**
     * Creates a rocket engine item by instantiating a new Item object that represents a rocket engine in the game
     * The rocket engine has a skill GameSkills.BUILDROCKETBASE
     *
     * @return an Item that represents a rocket engine
     */
    private Item createRocketEngine() {
        Item rocketEngine = Item.newInventoryItem("rocket engine", 'e');
        rocketEngine.addSkill(GameSkills.BUILDROCKETBASE);
        return rocketEngine;
    }

    /**
     * Creates an intrinsic weapon which throws a conical flask
     *
     * @return a newly instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(2, "throws a conical flask at");
    }
}
