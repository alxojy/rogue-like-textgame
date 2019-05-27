package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents a Rocket Item that can move the Actor to Moon
 * @author Team Kimchi
 */
public class RocketToTheMoon extends Item {

    private GameMap moon = MoonMap.getMap();
    private Actor subject;

    /**
     * Constructor
     *
     * @param player the player to be moved to Moon
     */
    RocketToTheMoon(Actor player) {
        super("rocket", '^');
        Item.newFurniture("rocket", '^');
        subject = player;
    }

    @Override
    public Actions getAllowableActions() {
        Actions actions = new Actions();
        if (checkSpacesuit() && checkOxygenTank()) {
            actions.add(new MoveActorAction(moon.at(MoonMap.ROCKET_X, MoonMap.ROCKET_Y), "to the Moon"));
        }
        return actions;
    }

    /**
     * Checks if the player's inventory has a Spacesuit item that has skill GameSkills.SPACETRAVELLER
     *
     * @return true if the player's inventory has a Spacesuit with GameSkills.SPACETRAVELLER. false otherwise
     */
    private boolean checkSpacesuit() {
        for (Item currentItem: subject.getInventory()) {
            if (currentItem.hasSkill(GameSkills.SPACETRAVELLER)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if player has OxygenTank Item in his inventory
     *
     * @return True if found, False if otherwise
     */
    private boolean checkOxygenTank() {
        for (Item currentItem: subject.getInventory()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)) {
                return true;
            }
        }
        return false;
    }
}