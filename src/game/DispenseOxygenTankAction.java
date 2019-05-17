package game;

import edu.monash.fit2099.engine.*;

public class DispenseOxygenTankAction extends Action {

    private Actor subject;
    private Location location;

    DispenseOxygenTankAction(Actor actor, Location location) {
        this.subject = actor;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        OxygenDispenserScheduler.counter.increment();
        actor.addItemToInventory(new OxygenTank());
        return "Oxygen tank has been dispensed";
    }

    @Override
    public String menuDescription(Actor actor) { return subject + " picks up oxygen tank";}

    @Override
    public String hotKey() {
        return "";
    }
}
