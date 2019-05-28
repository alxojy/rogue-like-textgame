package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an oxygen dispenser
 * @author Team Kimchi
 */
public class OxygenDispenser extends Ground {

    /**
     * Constructor.
     *
     * Initialises the char to display for the oxygen dispenser as 'O'.
     */
    public OxygenDispenser() {
        super('O');
    }

    /**
     * When an actor is adjacent to the oxygen dispenser, it checks if the oxygen tank is on the oxygen dispenser location
     * and if it contains an actor. If both are false, it will instantiate a new OxygenDispenserScheduler on its location.
     *
     * @param actor the Actor next to the OxygenDispenser
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return An empty List of Actions
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();

        if (!checkOxygenTank(location)) {
            actions.add(new DispenseOxygenTankAction(actor, location));
        }
        return actions;
    }

    /**
     * Checks if OxygenTank item that has skill GameSkills.OXYGENTANK is on the location of OxygenDispenser
     *
     * @param location the location of OxygenDispenser
     * @return true if the actor's inventory has the OxygenTank with GameSkills.OXYGENTANK. false otherwise
     */
    private boolean checkOxygenTank(Location location) {
        for (Item currentItem: location.getItems()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)) {
                return true;
            }
        }
        return false;
    }


}
