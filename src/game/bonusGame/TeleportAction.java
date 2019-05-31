package game.bonusGame;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an Action that teleports the actor,
 * it extends MoveActorAction
 * @author Team Kimchi
 */
public class TeleportAction extends MoveActorAction {

    private String direction;
    private Actor subject;
    private Item ticket;

    /**
     * Constructor to create a TeleportAction that will teleport the Actor to a Location
     *
     * @param moveToLocation the destination of the move
     * @param direction the direction of the move (to be displayed in menu)
     * @param subject the actor that will be teleported
     * @param ticket the ticket item that is required for teleportation
     */
    TeleportAction(Location moveToLocation, String direction, Actor subject, Item ticket) {
        super(moveToLocation,direction);
        this.direction = direction;
        this.subject = subject;
        this.ticket = ticket;
    }

    /**
     *This method calls it's super class execute() method to
     * teleport the subject actor to the given location, and removes a ticket
     * from the subject's inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action which was return from its super class
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        subject.removeItemFromInventory(ticket);
        return super.execute(actor, map);
    }


    /**
     * Returns a description of this action suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player teleports into locked room."
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports " + direction;
    }
}
