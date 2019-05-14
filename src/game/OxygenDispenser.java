package game;

import edu.monash.fit2099.engine.*;

public class OxygenDispenser extends Ground {

    private static MaxCounter dispenseCounter = new MaxCounter(2);
    private static boolean button = true;

    public OxygenDispenser() {
        super('O');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();

        if (!checkItems(location) && dispenseCounter.canIncrement()) {
            dispenseCounter.increment();
            actions.add(new DispenseOxygenTankAction(actor, location));
        }
        else if (!dispenseCounter.canIncrement()) {
            dispenseCounter.increment();
            new DispenseOxygenTankAction(actor, location);
        }
        return actions;
    }

    private boolean checkItems(Location location) {
        boolean itemPresent = false;
        for (Item currentItem: location.getItems()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)) {
                itemPresent = true;
            }
        }
        return itemPresent;
    }

    public static boolean canPressButton() {
        if (dispenseCounter.canIncrement()) {
            return true;
        }
        return false;
    }

}
