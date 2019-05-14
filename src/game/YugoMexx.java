package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an actor who is a miniboss called Yugo Maxx
 * @author Team Kimchi
 */
public class YugoMexx extends Actor {

    private GamePlayer player;

    private List<ActionFactory> actionFactories = new ArrayList<>();

    YugoMexx(String name, GamePlayer player) {
        super(name, 'm', 6, Grunt.GRUNT_HITPOINTS/2);
        this.player = player;
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

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            Location yugoLocation = map.locationOf(this);
            Location playerLocation = map.locationOf(player);
            if (!Distance.isAdjacent(yugoLocation, playerLocation)) {
                return action;
            }
        }

        return new AttackAction(this, player);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(Goon.GOON_DAMAGE, "punches");
    }
}
