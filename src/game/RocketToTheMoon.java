package game;

import edu.monash.fit2099.engine.*;

public class RocketToTheMoon extends Item {

    private GameMap moon = MoonMap.getMap();
    private Actor subject;

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

    private boolean checkSpacesuit() {
        for (Item currentItem: subject.getInventory()) {
            if (currentItem.hasSkill(GameSkills.SPACETRAVELLER)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOxygenTank() {
        for (Item currentItem: subject.getInventory()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)) {
                return true;
            }
        }
        return false;
    }
}