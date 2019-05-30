package game.bonusGame;

import edu.monash.fit2099.engine.*;


public class TeleportAction extends MoveActorAction {

    private String direction;
    private Actor subject;
    private Item ticket;

    TeleportAction(Location moveToLocation, String direction, Actor subject, Item ticket) {
        super(moveToLocation,direction);
        this.direction = direction;
        this.subject = subject;
        this.ticket = ticket;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        subject.removeItemFromInventory(ticket);
        return super.execute(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports " + direction;
    }
}
