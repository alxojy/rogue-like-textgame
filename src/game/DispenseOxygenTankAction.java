package game;

import edu.monash.fit2099.engine.*;

public class DispenseOxygenTankAction extends Action {

    private Actor subject;

    DispenseOxygenTankAction(Actor actor) {
        this.subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).addItem(new OxygenTank());
        map.removeActor(actor);
        return "Oxygen tank has been dispensed";
    }

    @Override
    public String menuDescription(Actor actor) { return subject + " picks up oxygen tank";}

    @Override
    public String hotKey() {
        return "";
    }
}
