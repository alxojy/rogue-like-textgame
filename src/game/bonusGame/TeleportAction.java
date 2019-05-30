package game.bonusGame;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;


public class TeleportAction extends MoveActorAction {
    private String direction;

    public TeleportAction(Location moveToLocation, String direction){
        super(moveToLocation,direction);
        this.direction = direction;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports " + direction;
    }
}
