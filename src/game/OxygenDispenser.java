package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenser extends Ground {

    public OxygenDispenser() {
        super('O');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();

        if (!checkOxygenTank(location) && !location.containsActor()) {
            location.map().addActor(new OxygenDispenserScheduler(actor), location.x(), location.y());
        }
        return actions;
    }

    /**
     * Checks if OxygenTank item that has skill GameSkills.OXYGENTANK is on location of OxygenDispenser
     *
     * @param location the location of OxygenDispenser
     * @return true if the actor's inventory has the OxygenTank with GameSkills.OXYGENTANK). false otherwise
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
