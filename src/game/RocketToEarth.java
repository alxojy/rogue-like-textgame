package game;

import edu.monash.fit2099.engine.*;
/**
 * This class represents a Rocket Item that can move the Actor to Earth
 * @author Team Kimchi
 */
public class RocketToEarth extends Item {

    private GameMap earth = EarthMap.getMap();

    /**
     * Constructor
     */
    RocketToEarth() {
        super("rocket", '^');
        Item.newFurniture("rocket", '^');
    }

    /**
     * When the actor is standing on the RocketToEarth item furniture, the actor can choose the option to fly to Earth.
     * @return
     */
    @Override
    public Actions getAllowableActions() {
        Actions actions = new Actions();
        actions.add(new MoveActorAction(earth.at(EarthMap.ROCKET_X, EarthMap.ROCKET_Y), "to Earth"));
        return actions;
    }


}