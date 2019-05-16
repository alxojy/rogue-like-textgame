package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenser extends Ground {

    public OxygenDispenser() {
        super('O');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();

        if (!checkItems(location) && !GamePlayer.buttonPressed) {
            actions.add(new DispenseOxygenTankAction(actor, location));
        }
        return actions;
    }

    private boolean checkItems(Location location) {
        for (Item currentItem: location.getItems()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)) {
                return true;
            }
        }
        return false;
    }

}