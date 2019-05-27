package game;

import edu.monash.fit2099.engine.*;
/**
 * This class represents a Rocket Item that can move the Actor to Earth
 * @author Team Kimchi
 */
public class RocketToEarth extends Item {

    private GameMap earth = EarthMap.getMap();
    private Actor subject;

    /**
     * Constructor
     *
     * @param player the player to be moved to Earth
     */
    RocketToEarth(Actor player) {
        super("rocket", '^');
        Item.newFurniture("rocket", '^');
        subject = player;
    }


    @Override
    public Actions getAllowableActions() {
        Actions actions = new Actions();
        actions.add(new MoveActorAction(earth.at(EarthMap.ROCKET_X, EarthMap.ROCKET_Y), "to Earth"));
        return actions;
    }


}