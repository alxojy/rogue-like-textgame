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
     * Constructor. Initialises a new furniture which represents the rocket
     *
     * @param player the player to be moved to Moon
     */
    RocketToTheMoon(Actor player) {
        super("rocket", '^');
        Item.newFurniture("rocket", '^');
        subject = player;
    }

    /**
     * When the actor is standing on the RocketToTheMoon item furniture, if the actor has the spacesuit and oxygen tank
     * item, the actor can choose the option to fly to the Moon.
     * @return actions that can be performed when the actor is standing on it
     */
    @Override
    public Actions getAllowableActions() {
        Actions actions = new Actions();
        if (checkSpacesuit() && checkOxygenTank()) {
            actions.add(new MoveActorAction(moon.at(MoonMap.ROCKET_X, MoonMap.ROCKET_Y), "to the Moon"));
        }
        return actions;
    }

    /**
     * Checks if the player's inventory has a spacesuit item that has skill GameSkills.SPACETRAVELLER
     *
     * @return true if the player's inventory has a spacesuit with GameSkills.SPACETRAVELLER. false otherwise
     */
    private boolean checkSpacesuit() {
        return subject.hasSkill(GameSkills.SPACETRAVELLER);
    }

    /**
     * Checks if player has OxygenTank Item in his inventory
     *
     * @return True if found, False if otherwise
     */
    private boolean checkOxygenTank() {
        return subject.hasSkill(GameSkills.OXYGENTANK);
    }
}