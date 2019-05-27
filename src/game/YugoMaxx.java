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

     * YugoMaxx has the same hitPoint as Grunt and are always represented with a 'y'.
     * Constructor calls addBehaviour to add WanderBehaviour which allows yugoMaxx to wonder around the map.
     *
     * @param name Name of the yugoMaxx object
     * @param player Player in the game
     */
    YugoMaxx(String name, GamePlayer player) {
        super(name, 'y', 6, Grunt.GRUNT_HITPOINTS);
        this.player = player;
        addBehaviour(new WanderBehaviour());
    }


    /**
     * Adds the behaviour of yugoMaxx into a List of behaviours.
     *
     * @param behaviour The behaviour to be added.
     */
    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * Returns a suitable Action for yugoMaxx to perform.
     *
     * The playTurn method iterates through the List of behaviours  and checks if yugoMaxx is adjacent to the player.
     * If it is not adjacent to the player, it will return an action. Else, it will return an AttackAction
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
     * Makes exoskeleton false to give the impression that exoskeleton is removed.
     */
    public void removeExoskeleton() {exoskeleton = false;}

    /**
     *Returns the state of exoskeleton.
     * @return True, if exoskeleton is still effective. False otherwise.
     */
    public boolean hasExoskeleton() {return exoskeleton;}
}
