package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class PressButtonAction extends Action {

    private Actor subject;

    PressButtonAction(Actor actor) {
        this.subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        OxygenDispenserScheduler.counter.increment();
        return "Waiting for Oxygen tank to be dispensed";
    }

    @Override
    public String menuDescription(Actor actor) { return subject + " presses the button to dispense an oxygen tank";}

    @Override
    public String hotKey() {
        return "";
    }
}
