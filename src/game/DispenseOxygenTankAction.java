package game;

import edu.monash.fit2099.engine.*;

public class DispenseOxygenTankAction extends Action {

    Actor subject;
    Location location;

    DispenseOxygenTankAction(Actor actor, Location location) {
        this.subject = actor;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.addItem(new OxygenTank(actor),location.x(),location.y());
        return "Rocket has been created";
    }

    @Override
    public String menuDescription() { return subject + " presses the button to dispense an oxygen tank";}
}
