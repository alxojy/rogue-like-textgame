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
        location.map().addItem(new OxygenTank(), location.x(), location.y());
        System.out.println("Oxygen tank has been dispensed");
        return "Waiting for Oxygen tank to be dispensed";
    }

    @Override
    public String menuDescription(Actor actor) { return subject + " presses the button to dispense an oxygen tank";}

    @Override
    public String hotKey() {
        return "";
    }
}
