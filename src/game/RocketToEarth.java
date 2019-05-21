package game;

import edu.monash.fit2099.engine.*;

public class RocketToEarth extends Item {

    private GameMap earth = EarthMap.getMap();
    private Actor subject;

    RocketToEarth(Actor player) {
        super("rocket", '^');
        Item.newFurniture("rocket", '^');
        subject = player;
    }

    @Override
    public Actions getAllowableActions() {
        Actions actions = new Actions();
        removeOxygenMoonSkill();
        actions.add(new MoveActorAction(earth.at(EarthMap.ROCKET_X, EarthMap.ROCKET_Y), "to Earth"));
        return actions;
    }

    private void removeOxygenMoonSkill(){
        for (Item currentItem: subject.getInventory()) {
            if (currentItem.hasSkill(GameSkills.OXYGENMOON)) {
                currentItem.removeSkill(GameSkills.OXYGENMOON);
            }
    }
}
}