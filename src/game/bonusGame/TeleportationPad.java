package game.bonusGame;

import edu.monash.fit2099.engine.*;

public class TeleportationPad extends Item {

    private Actor subject;

    /**
     * Constructor
     *
     * @param player the player to be moved to Earth
     */
    public TeleportationPad(Actor player) {
        super("teleportation pad", '⎔');
        Item.newFurniture("teleportation pad", '⎔');
        subject = player;
    }


//    @Override
//    public Actions getAllowableActions() {
//        Actions actions = new Actions();
//        actions.add(new MoveActorAction(earth.at(EarthMap.ROCKET_X, EarthMap.ROCKET_Y), "to Earth"));
//        return actions;
//    }


}
