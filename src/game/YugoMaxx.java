package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an actor who is a miniboss called Yugo Maxx
 * @author Team Kimchi
 */
public class YugoMaxx extends Actor {

    private GamePlayer player;
    private boolean exoskeleton = true;

    private List<ActionFactory> actionFactories = new ArrayList<>();

    /**
     * Constructor.

     * Yugo Maxx has 50 hitPoints and is always represented with a 'y'.
     * Constructor calls addBehaviour to add WanderBehaviour which allows Yugo Maxx to wonder around the map.
     *
     * @param name Name of the yugoMaxx object
     * @param player Player in the game
     */
    YugoMaxx(String name, GamePlayer player) {
        super(name, 'y', 6, 50);
        this.player = player;
        addBehaviour(new WanderBehaviour());
    }


    /**
     * Adds the behaviour of Yugo Maxx into a List of behaviours.
     *
     * @param behaviour The behaviour to be added.
     */
    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * Returns a suitable Action for Yugo Maxx to perform.
     *
     * The playTurn method iterates through the List of behaviours and checks if Yugo Maxx is adjacent to the player.
     * If it is not adjacent to the player, it will return its behaviour's Action. Else, it will return an AttackAction
     *
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the selected action to be perform on the current turn
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            Location yugoLocation = map.locationOf(this);
            if (!Distance.isAdjacent(yugoLocation, player)) {
                return action;
            }
        }
        return new AttackAction(this, player);
    }

    /**
     * Returns a List of Actions that can be performed by the actor adjacent to Yugo Maxx.
     *
     * Adds a newly instantiated SquirtingWaterAction into a List of Actions that the otherActor can be performed if they
     * have a filled water pistol and Yugo Maxx's exoskeleton is present.
     * A newly instantiated AttackYugoAction is always added into a List of Actions.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A List of Actions that can be performed by the actor adjacent to Yugo Maxx.
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        for (Item currentItem: otherActor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.PISTOLISFULL) && exoskeleton) {
                actions.add(new SquirtingWaterAction(this, currentItem));
            }
        }
        actions.add(new AttackYugoAction(player, this));
        return actions;
    }

    /**
     * Creates an intrinsic weapon which punches.
     * This intrinsic weapon does equal damage as Goon.
     *
     * @return a newly instantiated IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(Goon.GOON_DAMAGE, "punches");
    }

    /**
     * Remove Yugo Maxx's exoskeleton
     */
    public void removeExoskeleton() {exoskeleton = false;}

    /**
     * Returns the state of exoskeleton.
     * @return true, if exoskeleton is present. false otherwise.
     */
    public boolean hasExoskeleton() {return exoskeleton;}
}
