package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that represents Q object which is also an Actor
 * @author Team Kimchi
 */
public class Q extends Actor {

    /**
     * List of behaviours that can be performed by Q.
     */
    private List<ActionFactory> actionFactories = new ArrayList<>();

    /**
     * Constructor.
     *
     * Calls addBehaviour to add WanderBehaviour for Q to wander around the map.
     */
    Q() {
        super("Q", 'Q', 5, 50);
        addBehaviour(new WanderBehaviour());
    }

    /**
     * Adds the behaviour of Q into a List of behaviours.
     *
     * @param behaviour The behaviour to be added.
     */
    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * Select and return an action to perform on the current turn.
     * Overrides Actor.playTurn() method to allow Q implement the wanderBehaviour
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
            if(action != null)
                return action;
        }

        return super.playTurn(actions,  map,  display);
    }

    /**
     * If otherActor's inventory contains rocket plans which has GameSkills.GETROCKETBODY, otherActor is
     * allowed to do GivePlansAction to the current Actor (Q)
     *
     * The otherActor is always allowed to do TalkAction when it is adjacent to the currentActor
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a collection of Actions
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        for (Item item : otherActor.getInventory()) {
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                actions.add(new GivePlansAction(otherActor, this));
            }
        }
        actions.add(new TalkAction(this, otherActor));
        return actions;
    }

}

