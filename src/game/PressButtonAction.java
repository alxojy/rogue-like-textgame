package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class PressButtonAction extends Action {

    private Actor subject;
    private MaxCounter counter;

    /**
     * Constructor.
     *
     * @param actor The actor performing the action
     * @param counter The counter to increment after the button is pressed
     */
    PressButtonAction(Actor actor, MaxCounter counter) {
        this.subject = actor;
        this.counter = counter;
    }

    /**
     * This overridden method performs the action of player pressing the button to dispense oxygen,
     * it increments the counter by 1.
     *
     * @param actor the actor performing this action (namely ; GamePlayer)
     * @param map The map the GamePlayer is on.
     * @return  A String describing that the oxygen will be dispensed shortly.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        counter.increment();
        return "Waiting for Oxygen tank to be dispensed";
    }

    /**
     * Returns a description of the press button action to display on the menu.
     *
     * @param actor The actor performing the action.
     * @return  a String describing the press button action
     */
    @Override
    public String menuDescription(Actor actor) { return subject + " presses the button to dispense an oxygen tank";}

    /**
     * Returns the empty String, as no hotKey is permanently assigned to PressButtonAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }
}
