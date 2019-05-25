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

    private boolean checkOxygenTank(Location location) {
        for (Item currentItem: location.getItems()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)) {
                return true;
            }
        }
        return false;
    }


}
