package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an Action that dispenses an oxygen tank item on the map
 * @author Team Kimchi
 */
public class DispenseOxygenTankAction extends Action {

    private Actor subject;
    private Location oxygenDispenserLocation;

    /**
     * Constructor.
     *
     * @param actor The actor performing the action of dispensing the oxygen tank
     */
    DispenseOxygenTankAction(Actor actor, Location location) {
        this.subject = actor;
        this.oxygenDispenserLocation = location;
    }

    /**
     * Performs the action of dispensing an oxygen tank on the map.
     *
     * Overrides its superclass's execute method and performs the following tasks:
     * 1. Adds an oxygen tank on the current location of the actor dispensing the oxygen tank (which in this case is
     * the OxygenDispenserScheduler object)
     * 2. Removes the actor from the map
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A String describing that an oxygen tank has been dispensed.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.addItem(new OxygenTank(), oxygenDispenserLocation.x(), oxygenDispenserLocation.y());
        return "Oxygen tank has been dispensed";
    }

    /**
     * Returns a description of the dispensing oxygen tank action to be printed on the menu.
     *
     * @param actor The actor performing the action.
     * @return a String of text to display on the menu.
     */
    @Override
    public String menuDescription(Actor actor) { return subject + " presses the button to dispense an oxygen tank";}

    /**
     * Returns the empty String, as no hotKey is permanently assigned to DispenseOxygenTankAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }
}
