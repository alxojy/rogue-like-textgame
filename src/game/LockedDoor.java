package game;
import edu.monash.fit2099.engine.*;

public class LockedDoor extends Ground {

    public LockedDoor() {
        super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        if (containsKey(actor)) {
            actions.add(new UnlockDoorAction(direction, location));
        }
        return actions;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }

    private boolean containsKey(Actor actor) {
        for (Item currentItem : actor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.UNLOCKDOOR)) {
                return true;
            }
        }
        return false;
    }

}
