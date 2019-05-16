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
        if (!GamePlayer.buttonPressed) {
            GamePlayer.actionScheduler.addActionToSchedule(this);
            GamePlayer.buttonPressed = true;
            return "Waiting for Oxygen tank to be dispensed";
        }
        else {
            GamePlayer.buttonPressed = false;
            location.map().addItem(new OxygenTank(), location.x(), location.y());
            return "Oxygen tank has been dispensed";
        }
    }

    @Override
    public String menuDescription(Actor actor) { return subject + " presses the button to dispense an oxygen tank";}

    @Override
    public String hotKey() {
        return "";
    }
}
